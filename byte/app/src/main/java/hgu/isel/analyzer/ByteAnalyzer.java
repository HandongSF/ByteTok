package hgu.isel.analyzer;

import hgu.isel.ByteTok;
import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.*;
import hgu.isel.structure.attribute.type.Deprecated;
import hgu.isel.structure.attribute.type.Module;
import hgu.isel.structure.attribute.type.Record;
import hgu.isel.structure.attribute.type.annotation.ElementValue;
import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;
import hgu.isel.structure.attribute.type.annotation.ParameterAnnotations;
import hgu.isel.structure.attribute.type.annotation.TypeAnnotation;
import hgu.isel.structure.attribute.type.annotation.elemet.union.*;
import hgu.isel.structure.attribute.type.boot.BootstrapArgument;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;
import hgu.isel.structure.attribute.type.exception.ExceptionIndexTable;
import hgu.isel.structure.attribute.type.exception.ExceptionTable;
import hgu.isel.structure.attribute.type.inner.InnerClassInformation;
import hgu.isel.structure.attribute.type.line.LineNumberTableInformation;
import hgu.isel.structure.attribute.type.local.LocalVariableTableInformation;
import hgu.isel.structure.attribute.type.local.LocalVariableTypeTableInformation;
import hgu.isel.structure.attribute.type.module.Exports;
import hgu.isel.structure.attribute.type.module.Opens;
import hgu.isel.structure.attribute.type.module.Provides;
import hgu.isel.structure.attribute.type.module.Requires;
import hgu.isel.structure.attribute.type.module.export.ExportIndex;
import hgu.isel.structure.attribute.type.module.open.OpenIndex;
import hgu.isel.structure.attribute.type.module.provide.ProvidesIndex;
import hgu.isel.structure.attribute.type.module.uses.UsesIndex;
import hgu.isel.structure.attribute.type.nest.Classes;
import hgu.isel.structure.attribute.type.packages.PackageIndex;
import hgu.isel.structure.attribute.type.parameter.Parameter;
import hgu.isel.structure.attribute.type.path.Path;
import hgu.isel.structure.attribute.type.path.TypePath;
import hgu.isel.structure.attribute.type.record.RecordComponentInformation;
import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.attribute.type.stack.frame.union.*;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;
import hgu.isel.structure.attribute.type.stack.verification.union.*;
import hgu.isel.structure.attribute.type.target.*;
import hgu.isel.structure.attribute.type.target.local.LocalVariableTargetTable;
import hgu.isel.structure.constant.type.*;
import hgu.isel.structure.field.FieldInformation;
import hgu.isel.structure.interfaces.Interfaces;
import hgu.isel.structure.method.MethodInformation;
import hgu.isel.structure.constant.ConstantPoolInformation;
import hgu.isel.tokenizer.ByteStructure;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;

public class ByteAnalyzer {
    private final byte[] bytes; // all bytes
    private byte[] magic = new byte[4]; // u4
    private byte[] minorVersion = new byte[2]; // u2
    private byte[] majorVersion = new byte[2]; // u2
    private byte[] constantPoolCount = new byte[2]; // u2
    private ConstantPoolInformation[] constantPoolInformation;
    private byte[] accessFlag = new byte[2]; // u2
    private byte[] thisClass = new byte[2]; // u2
    private byte[] superClass = new byte[2]; // u2
    private byte[] interfacesCount = new byte[2]; // u2
    private Interfaces[] interfaces; // interfacesCount
    private byte[] fieldsCount = new byte[2]; // u2
    private FieldInformation[] fieldInformation;
    private byte[] methodsCount = new byte[2]; // u2
    private MethodInformation[] methodInformation;
    private byte[] attributesCount = new byte[2]; // u2
    private AttributeInformation[] attributeInformation;
    private int offset = 0;
    private int cpCount;

    public ByteAnalyzer(byte[] bytes) {
        this.bytes = bytes;
    }

    public String printResult() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Magic Number: ");
        for(byte b : magic) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append("\nMinor Version: ");
        for(byte b : minorVersion) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append("\nMajor Version: ");
        for(byte b : majorVersion) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append("\nConstant Pool Count: ");
        for(byte b : constantPoolCount) {
            stringBuilder.append(String.format("%02X", b));
        }


        stringBuilder.append("\nConstant Pool: ");
        for(ConstantPoolInformation c : constantPoolInformation) {
            if(c != null) {
                stringBuilder.append(c.toString());
            }
        }



        stringBuilder.append("\nAccess Flag: ");
        for(byte b : accessFlag) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append("\nThis Class: ");
        for(byte b : thisClass) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append("\nSuper Class: ");
        for(byte b : superClass) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append("\nInterface Count: ");
        for(byte b : interfacesCount) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append("\nInterfaces: ");
        for(Interfaces i : interfaces) {
            stringBuilder.append(i.toString());
        }

        stringBuilder.append("\nFields Count: ");
        for(byte b : fieldsCount) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append("\nFields: ");
        for(FieldInformation f : fieldInformation) {
            stringBuilder.append(f.toString());
        }

        stringBuilder.append("\nMethods Count: ");
        for(byte b : methodsCount) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append("\nMethods: ");
        for(MethodInformation m : methodInformation) {
            stringBuilder.append(m.toString());
        }

        stringBuilder.append("\nAttributes Count: ");
        for(byte b : attributesCount) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append("\nAttributes: ");
        for(AttributeInformation a : attributeInformation) {
            stringBuilder.append(a.toString());
        }

        return stringBuilder.toString();

    }

    public ByteStructure analyze() throws Exception {

        analyzeMagicNumber();
        analyzeMinorVersion();
        analyzeMajorVersion();
        analyzeConstantPoolCount();
        analyzeConstantPool();
        analyzeAccessFlag();
        analyzeThisClass();
        analyzeSuperClass();
        analyzeInterfaceCount();
        analyzeInterfaces();
        analyzeFieldsCount();
        analyzeFields();
        analyzeMethodsCount();
        analyzeMethods();
        analyzeAttributeCount();
        this.attributeInformation = analyzeAttribute(((attributesCount[0] & 0xFF) << 8) | (attributesCount[1] & 0xFF));

        return new ByteStructure(magic, minorVersion, majorVersion, constantPoolCount, constantPoolInformation, accessFlag, thisClass, superClass, interfacesCount, interfaces, fieldsCount, fieldInformation, methodsCount, methodInformation, attributesCount, attributeInformation);
    }

    public void printConstantPool() {
        for(int i = 0; i < constantPoolInformation.length; i++) {
            if(constantPoolInformation[i] != null) {
                System.out.println(constantPoolInformation[i].toString());
            }
        }
    }

    public void analyzeMagicNumber() {
        this.magic = Arrays.copyOfRange(bytes, 0, 4);


        this.offset = offset + 4;

    }

    public void analyzeMinorVersion() {
        this.minorVersion =  Arrays.copyOfRange(bytes, offset, offset + 2);


        this.offset = offset + 2;

    }

    public void analyzeMajorVersion() {
        this.majorVersion =  Arrays.copyOfRange(bytes, offset, offset + 2);


        this.offset = offset + 2;

    }

    public void analyzeConstantPoolCount() {
        this.constantPoolCount = Arrays.copyOfRange(bytes, offset, offset + 2);


        this.offset = offset + 2;
        this.cpCount = ((constantPoolCount[0] & 0xFF) << 8) | (constantPoolCount[1] & 0xFF); // constant pool count

    }

    public void analyzeConstantPool() throws Exception {
        int count = 0;
        // 실제로 index 0이 사용되지 않기 때문에 constant pool count - 1개의 constant가 존재함
        this.constantPoolInformation = new ConstantPoolInformation[cpCount - 1];

        while(count < cpCount - 1) {
            ConstantPoolInformation information = createConstantPoolEntry();
            constantPoolInformation[count] = information;

            if(information instanceof LongInformation || information instanceof DoubleInformation) {
                count++;
            }

            count++;
        }

    }

    public ConstantPoolInformation createConstantPoolEntry() throws Exception {
        int tag = bytes[offset] & 0xFF;
        ConstantPoolInformation returnInformation;

        switch (tag) {
            case 1:
                int integerLength = ((bytes[offset + 1] & 0xFF) << 8) | (bytes[offset + 2] & 0xFF);
                byte[] byteLength = Arrays.copyOfRange(bytes, offset + 1, offset + 3);
                byte[] byteUTF = Arrays.copyOfRange(bytes, offset + 3, offset + integerLength + 3);

                returnInformation = new UTF8Information(bytes[offset], byteLength, byteUTF);
                offset = offset + 3 + integerLength;
                break;
            case 3:
                returnInformation = new IntegerInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 5));
                offset += 5;
                break;
            case 4:
                returnInformation = new FloatInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 5));
                offset += 5;
                break;
            case 5:
                returnInformation = new LongInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 5), Arrays.copyOfRange(bytes, offset + 5, offset + 9));
                offset += 9;
                break;
            case 6:
                returnInformation = new DoubleInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 5), Arrays.copyOfRange(bytes, offset + 5, offset + 9));
                offset += 9;
                break;
            case 7:
                returnInformation = new ClassInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3));
                offset += 3;
                break;
            case 8:
                returnInformation = new StringInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3));
                offset += 3;
                break;
            case 9:
                returnInformation = new FieldReferenceInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3), Arrays.copyOfRange(bytes, offset + 3, offset + 5));
                offset += 5;
                break;
            case 10:
                returnInformation = new MethodReferenceInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3), Arrays.copyOfRange(bytes, offset + 3, offset + 5));
                offset += 5;
                break;
            case 11:
                returnInformation = new InterfaceMethodReferenceInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3), Arrays.copyOfRange(bytes, offset + 3, offset + 5));
                offset += 5;
                break;
            case 12:
                returnInformation = new NameAndTypeInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3), Arrays.copyOfRange(bytes, offset + 3, offset + 5));
                offset += 5;
                break;
            case 15:
                returnInformation = new MethodHandleInformation(bytes[offset], bytes[offset + 1], Arrays.copyOfRange(bytes, offset + 2, offset + 4));
                offset += 4;
                break;
            case 16:
                returnInformation = new MethodTypeInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3));
                offset += 3;
                break;
            case 17:
                returnInformation = new DynamicInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3), Arrays.copyOfRange(bytes, offset + 3, offset + 5));
                offset += 5;
                break;
            case 18:
                returnInformation = new InvokeDynamicInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3), Arrays.copyOfRange(bytes, offset + 3, offset + 5));
                offset += 5;
                break;
            case 19:
                returnInformation = new ModuleInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3));
                offset += 3;
                break;
            case 20:
                returnInformation = new PackageInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 3));
                offset += 3;
                break;
            default:
                throw new Exception();
        }

        return returnInformation;
    }

    public void analyzeAccessFlag() {
        this.accessFlag = Arrays.copyOfRange(bytes, offset, offset + 2);


        this.offset = offset + 2;

    }

    public void analyzeThisClass() {
        this.thisClass = Arrays.copyOfRange(bytes, offset, offset + 2);


        this.offset = offset + 2;

    }

    public void analyzeSuperClass() {
        this.superClass = Arrays.copyOfRange(bytes, offset, offset + 2);


        this.offset = offset + 2;

    }

    public void analyzeInterfaceCount() {
        this.interfacesCount = Arrays.copyOfRange(bytes, offset, offset + 2);


        this.offset = offset + 2;

    }

    public void analyzeInterfaces() {
        int count = 0;
        int interfaceLength = ((interfacesCount[0] & 0xFF) << 8) | (interfacesCount[1] & 0xFF);
        interfaces = new Interfaces[interfaceLength];

        while(count < interfaceLength) {
            interfaces[count] = new Interfaces(Arrays.copyOfRange(bytes, offset, offset + 2));
            offset += 2;
            count ++;
        }
    }

    public void analyzeFieldsCount() {
        this.fieldsCount = Arrays.copyOfRange(bytes, offset, offset + 2);


        this.offset = offset + 2;




        int fieldsCount = ((this.fieldsCount[0] & 0xFF) << 8) | (this.fieldsCount[1] & 0xFF);

        this.fieldInformation = new FieldInformation[fieldsCount];
    }

    public void analyzeFields() throws UnsupportedEncodingException {
        int count = 0;
        int fieldsCount = ((this.fieldsCount[0] & 0xFF) << 8) | (this.fieldsCount[1] & 0xFF);

        while(count < fieldsCount) {
            fieldInformation[count] = createField();

            count++;
        }
    }

    public FieldInformation createField() throws UnsupportedEncodingException {
        byte[] accessFlags = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        byte[] nameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        byte[] descriptorIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        byte[] attributesCount = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        int attributesCountInteger = ((attributesCount[0] & 0xFF) << 8) | (attributesCount[1] & 0xFF);
        AttributeInformation[] attributeInformation = analyzeAttribute(attributesCountInteger);

        return new FieldInformation(accessFlags, nameIndex, descriptorIndex, attributesCount, attributeInformation);
    }

    public void analyzeMethodsCount() {
        this.methodsCount = Arrays.copyOfRange(bytes, offset, offset + 2);


        offset += 2;




        int methodsCount = ((this.methodsCount[0] & 0xFF) << 8) | (this.methodsCount[1] & 0xFF);

        this.methodInformation = new MethodInformation[methodsCount];
    }

    public void analyzeMethods() throws UnsupportedEncodingException {
        int count = 0;
        int methodsCount = ((this.methodsCount[0] & 0xFF) << 8) | (this.methodsCount[1] & 0xFF);

        while(count < methodsCount) {
            methodInformation[count] = createMethod();

            count++;
        }

    }

    public MethodInformation createMethod() throws UnsupportedEncodingException {
        byte[] accessFlags = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        byte[] nameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        byte[] descriptorIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        byte[] attributesCount = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        int attributesCountInteger = ((attributesCount[0] & 0xFF) << 8) | (attributesCount[1] & 0xFF);
        AttributeInformation[] attributeInformation = analyzeAttribute(attributesCountInteger);

        return new MethodInformation(accessFlags, nameIndex, descriptorIndex, attributesCount, attributeInformation);

    }

    public void analyzeAttributeCount() {
        this.attributesCount = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;
    }

    // 해당 method 실행 전에 무조건 offset 값 증가 시키기
    public AttributeInformation[] analyzeAttribute(int attributeSize) throws UnsupportedEncodingException {
        int count = 0;
        // input으로 들어온 size 만큼의 attribute 배열 생성
        AttributeInformation[] returnInformation = new AttributeInformation[attributeSize];

        while(count < attributeSize) {
            returnInformation[count] = createAttribute(); // index는 method 안에서 증가시켜야 함
            count++;
        }

        return returnInformation;
    }

    public AttributeInformation createAttribute() throws UnsupportedEncodingException {

        AttributeInformation returnInformation;
        int utf8Index = ((bytes[offset] & 0xFF) << 8) | (bytes[offset + 1] & 0xFF);
        UTF8Information utf8Information = (UTF8Information) constantPoolInformation[utf8Index - 1];


        byte[] attributeName = utf8Information.getBytes();
        byte[] attributeNameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
        byte[] attributeLength = Arrays.copyOfRange(bytes, offset + 2, offset + 6);
        offset += 6;

        if(Arrays.equals(attributeName, "ConstantValue".getBytes("UTF-8"))) {
            byte[] constantValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);

            returnInformation = new ConstantValue(attributeNameIndex, attributeLength, constantValueIndex);
            offset += 2;

        } else if(Arrays.equals(attributeName, "Code".getBytes("UTF-8"))) {
            byte[] maxStack = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            byte[] maxLocals = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            byte[] codeLength = Arrays.copyOfRange(bytes, offset, offset + 4);
            offset += 4;

            int lengthInteger = ((codeLength[0] & 0xFF) << 24) | ((codeLength[1] & 0xFF) << 16) | ((codeLength[2] & 0xFF) << 8) | (codeLength[3] & 0xFF);
            // tableswitch instruction 실행을 위해 해당 위치에서의 offset을 가지고 와야함
            int totalOffset = offset;

            byte[] code = Arrays.copyOfRange(bytes, offset, offset + lengthInteger);
            offset += lengthInteger;

            byte[] exceptionTableLength = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int exceptionTableLengthInteger = ((exceptionTableLength[0] & 0xFF) << 8) | (exceptionTableLength[1] & 0xFF);
            ExceptionTable[] exceptionTables = new ExceptionTable[exceptionTableLengthInteger];

            int exceptionCount = 0;
            while(exceptionCount < exceptionTableLengthInteger) {
                byte[] startPC = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] endPC = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] handlerPC = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] catchType = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                exceptionTables[exceptionCount] = new ExceptionTable(startPC, endPC, handlerPC, catchType);
                exceptionCount++;
            }

            byte[] attributesCount = Arrays.copyOfRange(bytes, offset, offset + 2);
            int attributesCountInteger = ((attributesCount[0] & 0xFF) << 8) | (attributesCount[1] & 0xFF);
            offset += 2;

            AttributeInformation[] attributes = analyzeAttribute(attributesCountInteger);

            returnInformation = new Code(attributeNameIndex, attributeLength, maxStack, maxLocals, codeLength, code, exceptionTableLength, exceptionTables, attributesCount, attributes, totalOffset);

        } else if(Arrays.equals(attributeName, "StackMapTable".getBytes("UTF-8"))) {
            byte[] numberOfEntries = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int numberOfEntriesInteger = ((numberOfEntries[0] & 0xFF) << 8) | (numberOfEntries[1] & 0xFF);

            StackMapFrame[] stackMapFrames = new StackMapFrame[numberOfEntriesInteger];
            int count = 0;

            while(count < numberOfEntriesInteger) {
                byte frame = bytes[offset];
                int frameType = bytes[offset] & 0xFF;
                offset += 1;

                if(frameType < 64) {
                    stackMapFrames[count] = new SameFrame(frame);

                } else if(frameType >= 64 && frameType < 128) {
                    VerificationTypeInformation verificationTypeInformation = analyzeVerificationTypeInformation();
                    stackMapFrames[count] = new SameLocals1StackItemFrame(frame, verificationTypeInformation);

                } else if(frameType == 247) {
                    byte[] offsetDelta = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;
                    VerificationTypeInformation verificationTypeInformation = analyzeVerificationTypeInformation();
                    stackMapFrames[count] = new SameLocals1StackItemFrameExtended(frame, offsetDelta, verificationTypeInformation);

                } else if(frameType >= 248 && frameType <= 250) {
                    byte[] offsetDelta = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    stackMapFrames[count] = new ChopFrame(frame, offsetDelta);

                } else if(frameType == 251) {
                    byte[] offsetDelta = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    stackMapFrames[count] = new SameFrameExtended(frame, offsetDelta);

                } else if(frameType >= 252 && frameType <= 254) {
                    int numberOfVerifications = frameType - 251;

                    byte[] offsetDelta = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    VerificationTypeInformation[] verificationTypeInformation = new VerificationTypeInformation[numberOfVerifications];
                    int loop = 0;

                    while(loop < numberOfVerifications) {
                        verificationTypeInformation[loop] = analyzeVerificationTypeInformation();

                        loop++;
                    }

                    stackMapFrames[count] = new AppendedFrame(frame, offsetDelta, verificationTypeInformation);

                } else if(frameType == 255) {
                    byte[] offsetDelta = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    byte[] numberOfLocals = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    int numberOfLocalsInteger = ((numberOfLocals[0] & 0xFF) << 8) | (numberOfLocals[1] & 0xFF);
                    VerificationTypeInformation[] locals = new VerificationTypeInformation[numberOfLocalsInteger];
                    int loop = 0;

                    while(loop < numberOfLocalsInteger) {
                        locals[loop] = analyzeVerificationTypeInformation();

                        loop++;
                    }

                    loop = 0;

                    byte[] numberOfStackItems = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;
                    int numberOfStackItemsInteger = ((numberOfStackItems[0] & 0xFF) << 8) | (numberOfStackItems[1] & 0xFF);
                    VerificationTypeInformation[] stack = new VerificationTypeInformation[numberOfStackItemsInteger];

                    while(loop < numberOfStackItemsInteger) {
                        stack[loop] = analyzeVerificationTypeInformation();

                        loop++;
                    }

                    stackMapFrames[count] = new FullFrame(frame, offsetDelta, numberOfLocals, locals, numberOfStackItems, stack);

                }
                count++;
            }
            returnInformation = new StackMapTable(attributeNameIndex, attributeLength, numberOfEntries, stackMapFrames);

        } else if(Arrays.equals(attributeName, "Exceptions".getBytes("UTF-8"))) {
            byte[] numberOfExceptions = Arrays.copyOfRange(bytes, offset, offset + 2);
            int numberOfExceptionsInteger = ((numberOfExceptions[0] & 0xFF) << 8) | (numberOfExceptions[1] & 0xFF);
            offset += 2;

            ExceptionIndexTable[] exceptionIndexTables = new ExceptionIndexTable[numberOfExceptionsInteger];
            int count = 0;

            while(count < numberOfExceptionsInteger) {
                exceptionIndexTables[count] = new ExceptionIndexTable(Arrays.copyOfRange(bytes, offset, offset + 2));
                offset += 2;

                count++;
            }

            returnInformation = new Exceptions(attributeNameIndex, attributeLength, numberOfExceptions, exceptionIndexTables);
        } else if(Arrays.equals(attributeName, "InnerClasses".getBytes("UTF-8"))) {
            byte[] numberOfClasses = Arrays.copyOfRange(bytes, offset, offset + 2);
            int numberOfClassesInteger = ((numberOfClasses[0] & 0xFF) << 8) | (numberOfClasses[1] & 0xFF);
            offset += 2;

            InnerClassInformation[] innerClasses = new InnerClassInformation[numberOfClassesInteger];
            int count = 0;

            while(count < numberOfClassesInteger) {
                byte[] innerClassInfoIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] outerClassInfoIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] innerNameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] innerClassAccessFlag = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                innerClasses[count] = new InnerClassInformation(innerClassInfoIndex, outerClassInfoIndex, innerNameIndex, innerClassAccessFlag);

                count++;
            }

            returnInformation = new InnerClasses(attributeNameIndex, attributeLength, numberOfClasses, innerClasses);

        } else if(Arrays.equals(attributeName, "EnclosingMethod".getBytes("UTF-8"))) {
            byte[] classIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            byte[] methodIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            returnInformation = new EnclosingMethod(attributeNameIndex, attributeLength, classIndex, methodIndex);

        } else if(Arrays.equals(attributeName, "Synthetic".getBytes("UTF-8"))) {
            returnInformation = new Synthetic(attributeNameIndex, attributeLength);

        } else if(Arrays.equals(attributeName, "Signature".getBytes("UTF-8"))) {
            byte[] signatureIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            returnInformation = new Signature(attributeNameIndex, attributeLength, signatureIndex);

        } else if(Arrays.equals(attributeName, "SourceFile".getBytes("UTF-8"))) {
            byte[] sourceFileIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            returnInformation = new SourceFile(attributeNameIndex, attributeLength, sourceFileIndex);

        } else if(Arrays.equals(attributeName, "SourceDebugExtension".getBytes("UTF-8"))) {
            int length = ((attributeLength[0] & 0xFF) << 8) | (attributeLength[1] & 0xFF);
            byte[] debugExtension = Arrays.copyOfRange(bytes, offset, offset + length);
            offset += length;

            returnInformation = new SourceDebugExtension(attributeNameIndex, attributeLength, debugExtension);

        } else if(Arrays.equals(attributeName, "LineNumberTable".getBytes("UTF-8"))) {
            byte[] lineNumberTableLength = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int length = ((lineNumberTableLength[0] & 0xFF) << 8) | (lineNumberTableLength[1] & 0xFF);
            int count = 0;

            LineNumberTableInformation[] information = new LineNumberTableInformation[length];

            while(count < length) {
                byte[] startPC = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] lineNumber = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                information[count] = new LineNumberTableInformation(startPC, lineNumber);

                count++;
            }

            returnInformation = new LineNumberTable(attributeNameIndex, attributeLength, lineNumberTableLength, information);

        } else if(Arrays.equals(attributeName, "LocalVariableTable".getBytes("UTF-8"))) {
            byte[] localVariableTableLength = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int localVariableTableLengthInteger = ((localVariableTableLength[0] & 0xFF) << 8) | (localVariableTableLength[1] & 0xFF);
            int count = 0;
            LocalVariableTableInformation[] localVariableTableInformation = new LocalVariableTableInformation[localVariableTableLengthInteger];

            while(count < localVariableTableLengthInteger) {
                byte[] startPC = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] length = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] nameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] descriptorIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] index = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                localVariableTableInformation[count] = new LocalVariableTableInformation(startPC, length, nameIndex, descriptorIndex, index);

                count++;
            }

            returnInformation = new LocalVariableTable(attributeNameIndex, attributeLength, localVariableTableLength, localVariableTableInformation);

        } else if(Arrays.equals(attributeName, "LocalVariableTypeTable".getBytes("UTF-8"))) {
            byte[] localVariableTypeTableLength = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int localVariableTypeTableLengthInteger = ((localVariableTypeTableLength[0] & 0xFF) << 8) | (localVariableTypeTableLength[1] & 0xFF);
            int count = 0;

            LocalVariableTypeTableInformation[] localVariableTypeTableInformation = new LocalVariableTypeTableInformation[localVariableTypeTableLengthInteger];

            while(count < localVariableTypeTableLengthInteger) {
                byte[] startPC = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] length = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] nameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] signatureIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] index = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                localVariableTypeTableInformation[count] = new LocalVariableTypeTableInformation(startPC, length, nameIndex, signatureIndex, index);

                count++;
            }

            returnInformation = new LocalVariableTypeTable(attributeNameIndex, attributeLength, localVariableTypeTableLength, localVariableTypeTableInformation);

        } else if(Arrays.equals(attributeName, "Deprecated".getBytes("UTF-8"))) {
            returnInformation = new Deprecated(attributeNameIndex, attributeLength);

        } else if(Arrays.equals(attributeName, "RuntimeVisibleAnnotations".getBytes("UTF-8"))) {
            byte[] numberOfAnnotations = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;
            int numberOfAnnotationsInteger = ((numberOfAnnotations[0] & 0xFF) << 8) | (numberOfAnnotations[1] & 0xFF);

            Annotation[] annotations = analyzeAnnotations(numberOfAnnotationsInteger);
            returnInformation = new RuntimeVisibleAnnotations(attributeNameIndex, attributeLength, numberOfAnnotations, annotations);

        } else if(Arrays.equals(attributeName, "RuntimeInvisibleAnnotations".getBytes("UTF-8"))) {
            byte[] numberOfAnnotations = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;
            int numberOfAnnotationsInteger = ((numberOfAnnotations[0] & 0xFF) << 8) | (numberOfAnnotations[1] & 0xFF);

            Annotation[] annotations = analyzeAnnotations(numberOfAnnotationsInteger);
            returnInformation = new RuntimeInvisibleAnnotations(attributeNameIndex, attributeLength, numberOfAnnotations, annotations);

        } else if(Arrays.equals(attributeName, "RuntimeVisibleParameterAnnotations".getBytes("UTF-8"))) {
            byte numberOfParameters = bytes[offset];
            offset += 1;
            int count = 0;
            ParameterAnnotations[] parameterAnnotations = new ParameterAnnotations[(int) numberOfParameters];

            while(count < (int) numberOfParameters) {
                byte[] numberOfAnnotations = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;
                int numberOfAnnotationsInteger = ((numberOfAnnotations[0] & 0xFF) << 8) | (numberOfAnnotations[1] & 0xFF);

                Annotation[] annotations = analyzeAnnotations(numberOfAnnotationsInteger);
                parameterAnnotations[count] = new ParameterAnnotations(numberOfAnnotations, annotations);

                count++;
            }
            returnInformation = new RuntimeVisibleParameterAnnotations(attributeNameIndex, attributeLength, numberOfParameters, parameterAnnotations);


        } else if(Arrays.equals(attributeName, "RuntimeInvisibleParameterAnnotations".getBytes("UTF-8"))) {
            byte numberOfParameters = bytes[offset];
            offset += 1;
            int count = 0;
            ParameterAnnotations[] parameterAnnotations = new ParameterAnnotations[(int) numberOfParameters];

            while(count < (int) numberOfParameters) {
                byte[] numberOfAnnotations = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;
                int numberOfAnnotationsInteger = ((numberOfAnnotations[0] & 0xFF) << 8) | (numberOfAnnotations[1] & 0xFF);

                Annotation[] annotations = analyzeAnnotations(numberOfAnnotationsInteger);
                parameterAnnotations[count] = new ParameterAnnotations(numberOfAnnotations, annotations);

                count++;
            }

            returnInformation = new RuntimeInvisibleParameterAnnotations(attributeNameIndex, attributeLength, numberOfParameters, parameterAnnotations);

        } else if(Arrays.equals(attributeName, "RuntimeVisibleTypeAnnotations".getBytes("UTF-8"))) {
            byte[] numberOfAnnotations = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;
            int numberOfAnnotationsInteger = ((numberOfAnnotations[0] & 0xFF) << 8) | (numberOfAnnotations[1] & 0xFF);
            int count = 0;

            TypeAnnotation[] typeAnnotations = new TypeAnnotation[numberOfAnnotationsInteger];

            while(count < numberOfAnnotationsInteger) {
                typeAnnotations[count] = analyzeTypeAnnotations();

                count++;
            }

            returnInformation = new RuntimeVisibleTypeAnnotations(attributeNameIndex, attributeLength, numberOfAnnotations, typeAnnotations);

        } else if(Arrays.equals(attributeName, "RuntimeInvisibleTypeAnnotations".getBytes("UTF-8"))) {
            byte[] numberOfAnnotations = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;
            int numberOfAnnotationsInteger = ((numberOfAnnotations[0] & 0xFF) << 8) | (numberOfAnnotations[1] & 0xFF);
            int count = 0;

            TypeAnnotation[] typeAnnotations = new TypeAnnotation[numberOfAnnotationsInteger];

            while(count < numberOfAnnotationsInteger) {
                typeAnnotations[count] = analyzeTypeAnnotations();

                count++;
            }

            returnInformation = new RuntimeInvisibleTypeAnnotations(attributeNameIndex, attributeLength, numberOfAnnotations, typeAnnotations);

        } else if(Arrays.equals(attributeName, "AnnotationDefault".getBytes("UTF-8"))) {
            ElementValue elementValue = createElementValue();

            returnInformation = new AnnotationDefault(attributeNameIndex, attributeLength, elementValue);

        } else if(Arrays.equals(attributeName, "BootstrapMethods".getBytes("UTF-8"))) {
            byte[] numberOfBootstrapMethods = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int numberOfBootstrapMethodsInteger = ((numberOfBootstrapMethods[0] & 0xFF) << 8) | (numberOfBootstrapMethods[1] & 0xFF);
            int count = 0;
            BootstrapMethodInformation[] bootstrapMethodInformation = new BootstrapMethodInformation[numberOfBootstrapMethodsInteger];

            while(count < numberOfBootstrapMethodsInteger) {
                byte[] bootstrapMethodReference = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] numberOfBootstrapArguments = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;
                int numberOfBootstrapArgumentsInteger = ((numberOfBootstrapArguments[0] & 0xFF) << 8) | (numberOfBootstrapArguments[1] & 0xFF);

                int bootstrapCount = 0;
                BootstrapArgument[] bootstrapArguments = new BootstrapArgument[numberOfBootstrapArgumentsInteger];

                while(bootstrapCount < numberOfBootstrapArgumentsInteger) {
                    bootstrapArguments[bootstrapCount] = new BootstrapArgument(Arrays.copyOfRange(bytes, offset, offset + 2));
                    offset += 2;

                    bootstrapCount++;
                }

                bootstrapMethodInformation[count] = new BootstrapMethodInformation(bootstrapMethodReference, numberOfBootstrapArguments, bootstrapArguments);

                count++;
            }

            returnInformation = new BootstrapMethods(attributeNameIndex, attributeLength, numberOfBootstrapMethods, bootstrapMethodInformation);


        } else if(Arrays.equals(attributeName, "MethodParameters".getBytes("UTF-8"))) {
            byte parametersCount = bytes[offset];
            offset += 1;
            int count = 0;
            Parameter[] parameters = new Parameter[parametersCount];

            while(count < parametersCount) {
                byte[] nameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] accessFlag = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                parameters[count] = new Parameter(nameIndex, accessFlag);

                count++;
            }

            returnInformation = new MethodParameters(attributeNameIndex, attributeLength, parametersCount, parameters);

        } else if(Arrays.equals(attributeName, "Module".getBytes("UTF-8"))) {
            byte[] moduleNameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            byte[] moduleFlags = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            byte[] moduleVersionIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            byte[] requiresCount = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int requiresCountInteger = ((requiresCount[0] & 0xFF) << 8) | (requiresCount[1] & 0xFF);
            Requires[] requires = new Requires[requiresCountInteger];
            int count = 0;

            while(count < requiresCountInteger) {
                byte[] requiresIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] requiresFlags = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] requiresVersionIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                requires[count] = new Requires(requiresIndex, requiresFlags, requiresVersionIndex);

                count++;
            }

            byte[] exportsCount = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int exportsCountInteger = ((exportsCount[0] & 0xFF) << 8) | (exportsCount[1] & 0xFF);
            Exports[] exports = new Exports[exportsCountInteger];
            count = 0;

            while(count < exportsCountInteger) {
                byte[] exportsIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] exportsFlags = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] exportsToCount = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;
                int exportsToCountInteger = ((exportsToCount[0] & 0xFF) << 8) | (exportsToCount[1] & 0xFF);
                ExportIndex[] exportIndices = new ExportIndex[exportsToCountInteger];
                int loop = 0;

                while(loop < exportsToCountInteger) {
                    exportIndices[loop] = new ExportIndex(Arrays.copyOfRange(bytes, offset, offset + 2));
                    offset += 2;

                    loop++;
                }
                exports[count] = new Exports(exportsIndex, exportsFlags, exportsToCount, exportIndices);
                count++;
            }

            byte[] opensCount = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int opensCountInteger = ((opensCount[0] & 0xFF) << 8) | (opensCount[1] & 0xFF);
            Opens[] opens = new Opens[opensCountInteger];
            count = 0;

            while(count < opensCountInteger) {
                byte[] opensIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] opensFlags = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] opensToCount = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                int opensToCountInteger = ((opensToCount[0] & 0xFF) << 8) | (opensToCount[1] & 0xFF);
                OpenIndex[] openToIndex = new OpenIndex[opensToCountInteger];
                int loop = 0;

                while(loop < opensToCountInteger) {
                    openToIndex[loop] = new OpenIndex(Arrays.copyOfRange(bytes, offset, offset + 2));
                    offset += 2;

                    loop++;
                }
                opens[count] = new Opens(opensIndex, opensFlags, opensToCount, openToIndex);

                count++;
            }

            byte[] usesCount = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int usesCountInteger = ((usesCount[0] & 0xFF) << 8) | (usesCount[1] & 0xFF);
            UsesIndex[] usesIndex = new UsesIndex[usesCountInteger];
            count = 0;

            while(count < usesCountInteger) {
                usesIndex[count] = new UsesIndex(Arrays.copyOfRange(bytes, offset, offset + 2));
                offset += 2;

                count++;
            }

            byte[] providesCount = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;
            int providesCountInteger = ((providesCount[0] & 0xFF) << 8) | (providesCount[1] & 0xFF);
            count = 0;
            Provides[] provides = new Provides[providesCountInteger];

            while(count < providesCountInteger) {
                byte[] providesIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] providesWithCount = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;


                int providesWithCountInteger = ((providesWithCount[0] & 0xFF) << 8) | (providesWithCount[1] & 0xFF);
                ProvidesIndex[] providesWithIndex = new ProvidesIndex[providesWithCountInteger];
                int loop = 0;

                while(loop < providesWithCountInteger) {
                    providesWithIndex[loop] = new ProvidesIndex(Arrays.copyOfRange(bytes, offset, offset + 2));
                    offset += 2;

                    loop++;
                }

                provides[count] = new Provides(providesIndex, providesWithCount, providesWithIndex);

                count++;
            }
            returnInformation = new Module(attributeNameIndex, attributeLength, moduleNameIndex, moduleFlags, moduleVersionIndex, requiresCount, requires, exportsCount, exports, opensCount, opens, usesCount, usesIndex, providesCount, provides);

        } else if(Arrays.equals(attributeName, "ModulePackages".getBytes("UTF-8"))) {
            byte[] packageCount = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;
            int packageCountInteger = ((packageCount[0] & 0xFF) << 8) | (packageCount[1] & 0xFF);
            int count = 0;
            PackageIndex[] packageIndex = new PackageIndex[packageCountInteger];

            while(count < packageCountInteger) {
                packageIndex[count] = new PackageIndex(Arrays.copyOfRange(bytes, offset, offset + 2));
                offset += 2;

                count++;
            }

            returnInformation = new ModulePackages(attributeNameIndex, attributeLength, packageCount, packageIndex);


        } else if(Arrays.equals(attributeName, "ModuleMainClass".getBytes("UTF-8"))) {
            byte[] mainClassIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            returnInformation = new ModuleMainClass(attributeNameIndex, attributeLength, mainClassIndex);

        } else if(Arrays.equals(attributeName, "NestHost".getBytes("UTF-8"))) {
            byte[] hostClassIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            returnInformation = new NestHost(attributeNameIndex, attributeLength, hostClassIndex);

        } else if(Arrays.equals(attributeName, "NestMembers".getBytes("UTF-8"))) {
            byte[] numberOfClasses = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;
            int numberOfClassesInteger = ((numberOfClasses[0] & 0xFF) << 8) | (numberOfClasses[1] & 0xFF);
            int count = 0;
            Classes[] classes = new Classes[numberOfClassesInteger];

            while(count < numberOfClassesInteger) {
                classes[count] = new Classes(Arrays.copyOfRange(bytes, offset, offset + 2));
                offset += 2;

                count++;
            }
            returnInformation = new NestMembers(attributeNameIndex, attributeLength, numberOfClasses, classes);

        } else if(Arrays.equals(attributeName, "Record".getBytes("UTF-8"))) {
            byte[] componentsCount = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;
            int componentsCountInteger = ((componentsCount[0] & 0xFF) << 8) | (componentsCount[1] & 0xFF);
            int count = 0;

            RecordComponentInformation[] information = new RecordComponentInformation[componentsCountInteger];

            while(count < componentsCountInteger) {
                byte[] nameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] descriptorIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] attributesCount = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;
                int attributesCountInteger = ((attributesCount[0] & 0xFF) << 8) | (attributesCount[1] & 0xFF);
                AttributeInformation[] attributeInformation = analyzeAttribute(attributesCountInteger);

                information[count] = new RecordComponentInformation(nameIndex, descriptorIndex, attributesCount, attributeInformation);

                count++;
            }

            returnInformation = new Record(attributeNameIndex, attributeLength, componentsCount, information);

        } else if(Arrays.equals(attributeName, "PermittedSubclasses".getBytes("UTF-8"))) {
            byte[] numberOfClasses = Arrays.copyOfRange(bytes, offset, offset + 2);
            offset += 2;

            int numberOfClassesInteger = ((numberOfClasses[0] & 0xFF) << 8) | (numberOfClasses[1] & 0xFF);
            Classes[] classes = new Classes[numberOfClassesInteger];
            int count = 0;

            while(count < numberOfClassesInteger) {
                classes[count] = new Classes(Arrays.copyOfRange(bytes, offset, offset + 2));
                offset += 2;

                count++;
            }
            returnInformation = new PermittedSubClasses(attributeNameIndex, attributeLength, numberOfClasses, classes);

        } else {

            HashSet<String> customAttributes = ByteTok.getCustomAttributes();
            customAttributes.add(new String(attributeName, StandardCharsets.UTF_8)); // add custom attribute name static variable
            ByteTok.setCustomAttributes(customAttributes);

            System.out.println(new String(attributeName, StandardCharsets.UTF_8));

            int attributeContents = ((attributeLength[0] & 0xFF) << 24) | ((attributeLength[1] & 0xFF) << 16) | ((attributeLength[2] & 0xFF) << 8) | (attributeLength[3] & 0xFF);

            byte[] attributeContentsByte = Arrays.copyOfRange(bytes, offset, offset + attributeContents);
            offset += attributeContents;

            returnInformation = new CustomDefined(attributeNameIndex, attributeLength, attributeContentsByte);
        }

        return returnInformation;
    }

    public VerificationTypeInformation analyzeVerificationTypeInformation() {
        VerificationTypeInformation verificationTypeInformation;

        byte tag = bytes[offset];
        offset += 1;

        switch(tag) {
            case 0:
                verificationTypeInformation = new TopVariableInformation();
                break;
            case 1:
                verificationTypeInformation = new IntegerVariableInformation();
                break;
            case 2:
                verificationTypeInformation = new FloatVariableInformation();
                break;
            case 3:
                verificationTypeInformation = new DoubleVariableInformation();
                break;
            case 4:
                verificationTypeInformation = new LongVariableInformation();
                break;
            case 5:
                verificationTypeInformation = new NullVariableInformation();
                break;
            case 6:
                verificationTypeInformation = new UninitializedThisVariableInformation();
                break;
            case 7:
                verificationTypeInformation = new ObjectVariableInformation(Arrays.copyOfRange(bytes, offset, offset + 2));
                offset += 2;
                break;
            case 8:
                verificationTypeInformation = new UninitializedVariableInformation(Arrays.copyOfRange(bytes, offset, offset + 2));
                offset += 2;
                break;
            default:
                throw new Error();
        }
        return verificationTypeInformation;
    }

    public TypeAnnotation analyzeTypeAnnotations() {
        byte targetType = bytes[offset];
        offset += 1;
        TargetInformation targetInformation;



        byte[] tableLength;
        int tableLengthInteger;
        LocalVariableTargetTable[] table;
        int tableLengthCount = 0;
        byte[] offsetTarget;
        byte typeArgumentIndex;

        switch (targetType) {
            case 0x00:
                targetInformation = new TypeParameterTarget(bytes[offset]);
                offset += 1;

                break;
            case 0x01:
                targetInformation = new TypeParameterTarget(bytes[offset]);
                offset += 1;

                break;
            case 0x10:
                targetInformation = new SuperTypeTarget(Arrays.copyOfRange(bytes, offset, offset + 2));
                offset += 2;

                break;
            case 0x11:
                targetInformation = new TypeParameterBoundTarget(bytes[offset], bytes[offset + 1]);
                offset += 2;

                break;
            case 0x12:
                targetInformation = new TypeParameterBoundTarget(bytes[offset], bytes[offset + 1]);
                offset += 2;

                break;
            case 0x13:
                targetInformation = new EmptyTarget();

                break;
            case 0x14:
                targetInformation = new EmptyTarget();

                break;
            case 0x15:
                targetInformation = new EmptyTarget();

                break;
            case 0x16:
                targetInformation = new FormalParameterTarget(bytes[offset]);
                offset += 1;

                break;
            case 0x17:
                targetInformation = new ThrowsTarget(Arrays.copyOfRange(bytes, offset, offset + 2));
                offset += 2;

                break;
            case 0x40:
                tableLength = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;
                tableLengthInteger = ((tableLength[0] & 0xFF) << 8) | (tableLength[1] & 0xFF);
                table = new LocalVariableTargetTable[tableLengthInteger];

                while(tableLengthCount < tableLengthInteger) {
                    byte[] startPC = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    byte[] length = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    byte[] index = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    table[tableLengthCount] = new LocalVariableTargetTable(startPC, length, index);

                    tableLengthCount++;
                }
                targetInformation = new LocalVariableTarget(tableLength, table);

                break;
            case 0x41:
                tableLength = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;
                tableLengthInteger = ((tableLength[0] & 0xFF) << 8) | (tableLength[1] & 0xFF);
                table = new LocalVariableTargetTable[tableLengthInteger];


                while(tableLengthCount < tableLengthInteger) {
                    byte[] startPC = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    byte[] length = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    byte[] index = Arrays.copyOfRange(bytes, offset, offset + 2);
                    offset += 2;

                    table[tableLengthCount] = new LocalVariableTargetTable(startPC, length, index);

                    tableLengthCount++;
                }
                targetInformation = new LocalVariableTarget(tableLength, table);

                break;
            case 0x42:
                byte[] exceptionTableIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                targetInformation = new CatchTarget(exceptionTableIndex);

                break;
            case 0x43:
                offsetTarget = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                targetInformation = new OffsetTarget(offsetTarget);


                break;
            case 0x44:
                offsetTarget = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                targetInformation = new OffsetTarget(offsetTarget);

                break;
            case 0x45:
                offsetTarget = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                targetInformation = new OffsetTarget(offsetTarget);

                break;
            case 0x46:
                offsetTarget = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                targetInformation = new OffsetTarget(offsetTarget);

                break;
            case 0x47:
                offsetTarget = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                typeArgumentIndex = bytes[offset];
                offset += 1;

                targetInformation = new TypeArgumentTarget(offsetTarget, typeArgumentIndex);

                break;
            case 0x48:
                offsetTarget = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                typeArgumentIndex = bytes[offset];
                offset += 1;

                targetInformation = new TypeArgumentTarget(offsetTarget, typeArgumentIndex);

                break;
            case 0x49:
                offsetTarget = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                typeArgumentIndex = bytes[offset];
                offset += 1;

                targetInformation = new TypeArgumentTarget(offsetTarget, typeArgumentIndex);

                break;
            case 0x4A:
                offsetTarget = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                typeArgumentIndex = bytes[offset];
                offset += 1;

                targetInformation = new TypeArgumentTarget(offsetTarget, typeArgumentIndex);

                break;
            case 0x4B:
                offsetTarget = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                typeArgumentIndex = bytes[offset];
                offset += 1;

                targetInformation = new TypeArgumentTarget(offsetTarget, typeArgumentIndex);

                break;
            default:
                throw new Error();
        }
        TypePath typePath = analyzeTypePath();
        byte[] typeIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        byte[] numberOfElementValuePairs = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;
        int numberOfElementValuePairsInteger = ((numberOfElementValuePairs[0] & 0xFF) << 8) | (numberOfElementValuePairs[1] & 0xFF);
        ElementValuePairs[] elementValuePairs = analyzeElementValuePairs(numberOfElementValuePairsInteger);

        return new TypeAnnotation(targetType, targetInformation, typePath, typeIndex, numberOfElementValuePairs, elementValuePairs);
    }

    public TypePath analyzeTypePath() {
        byte pathLength = bytes[offset];
        offset += 1;

        int count = 0;
        Path[] path = new Path[pathLength];


        while(count < pathLength) {
            path[count] = new Path(bytes[offset], bytes[offset + 1]);
            offset += 2;
            count++;
        }

        return new TypePath(pathLength, path);
    }

    public Annotation[] analyzeAnnotations(int numberOfAnnotations) {
        int count = 0;
        Annotation[] annotations = new Annotation[numberOfAnnotations];

        while(count < numberOfAnnotations) {
            annotations[count] = createAnnotation();

            count++;
        }

        return annotations;
    }

    public Annotation createAnnotation() {
        byte[] typeIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        byte[] numberOfElementValuePairs = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;
        int numberOfElementValuePairsInteger = ((numberOfElementValuePairs[0] & 0xFF) << 8) | (numberOfElementValuePairs[1] & 0xFF);
        ElementValuePairs[] elementValuePairs = analyzeElementValuePairs(numberOfElementValuePairsInteger);

        return new Annotation(typeIndex, numberOfElementValuePairs, elementValuePairs);
    }

    public ElementValuePairs[] analyzeElementValuePairs(int numberOfElementValuePairs) {
        int count = 0;
        ElementValuePairs[] elementValuePairs = new ElementValuePairs[numberOfElementValuePairs];

        while(count < numberOfElementValuePairs) {
            elementValuePairs[count] = createElementValuePairs();

            count++;
        }

        return elementValuePairs;
    }

    public ElementValuePairs createElementValuePairs() {
        byte[] elementNameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
        offset += 2;

        byte tag = bytes[offset];
        offset += 1;
        ElementValue elementValue;
        byte[] constValueIndex;

        switch (tag) {
            case (byte) 'B':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'C':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'D':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'F':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'I':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'J':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'S':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'Z':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 's':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'e':
                byte[] typeNameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] constNameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new EnumConstValue(typeNameIndex, constNameIndex));
                break;
            case (byte) 'c':
                byte[] classInfoIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ClassInformationIndex(classInfoIndex));
                break;
            case (byte) '@':
                Annotation annotation = createAnnotation();
                elementValue = new ElementValue(tag, annotation);

                break;
            case (byte) '[':
                byte[] numberOfValues = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                int numberOfValuesInteger = ((numberOfValues[0] & 0xFF) << 8) | (numberOfValues[1] & 0xFF);
                ElementValue[] elementValues = analyzeElementValue(numberOfValuesInteger);
                elementValue = new ElementValue(tag, new ArrayValue(numberOfValues, elementValues));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + tag);
        }

        return new ElementValuePairs(elementNameIndex, elementValue);
    }

    public ElementValue[] analyzeElementValue(int numberOfElementValue) {
        int count = 0;

        ElementValue[] elementValues = new ElementValue[numberOfElementValue];

        while(count < numberOfElementValue) {
            elementValues[count] = createElementValue();

            count++;
        }

        return elementValues;
    }

    public ElementValue createElementValue() {
        byte tag = bytes[offset];
        offset += 1;
        ElementValue elementValue;
        byte[] constValueIndex;

        switch (tag) {
            case (byte) 'B':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'C':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'D':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'F':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'I':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'J':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'S':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'Z':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 's':
                constValueIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ConstValueIndex(constValueIndex));
                break;
            case (byte) 'e':
                byte[] typeNameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                byte[] constNameIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new EnumConstValue(typeNameIndex, constNameIndex));
                break;
            case (byte) 'c':
                byte[] classInfoIndex = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                elementValue = new ElementValue(tag, new ClassInformationIndex(classInfoIndex));
                break;
            case (byte) '@':
                Annotation annotation = createAnnotation();
                elementValue = new ElementValue(tag, annotation);

                break;
            case (byte) '[':
                byte[] numberOfValues = Arrays.copyOfRange(bytes, offset, offset + 2);
                offset += 2;

                int numberOfValuesInteger = ((numberOfValues[0] & 0xFF) << 8) | (numberOfValues[1] & 0xFF);
                ElementValue[] elementValues = analyzeElementValue(numberOfValuesInteger);
                elementValue = new ElementValue(tag, new ArrayValue(numberOfValues, elementValues));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + tag);
        }

        return elementValue;
    }
















    public void check(byte[] input) {
        for(byte s : input) {
            System.out.printf("%02X", s);
        }
        System.out.println();
    }

    public int byteArrayToDecimal(byte[] byteArray) {
        // 바이트 배열을 순회하며, 각 바이트를 16진수로 결합하여 정수로 변환
        int result = 0;
        for (int i = 0; i < byteArray.length; i++) {
            result = (result << 8) | (byteArray[i] & 0xFF);  // 각 바이트를 왼쪽으로 시프트하여 결합
        }
        return result;  // 10진수 결과 반환
    }







    public byte[] getBytes() {
        return bytes;
    }

    public byte[] getMagic() {
        return magic;
    }

    public void setMagic(byte[] magic) {
        this.magic = magic;
    }

    public byte[] getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(byte[] minorVersion) {
        this.minorVersion = minorVersion;
    }

    public byte[] getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(byte[] majorVersion) {
        this.majorVersion = majorVersion;
    }

    public byte[] getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(byte[] constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    public ConstantPoolInformation[] getConstantPoolInformation() {
        return constantPoolInformation;
    }

    public void setConstantPoolInformation(ConstantPoolInformation[] constantPoolInformation) {
        this.constantPoolInformation = constantPoolInformation;
    }

    public byte[] getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(byte[] accessFlag) {
        this.accessFlag = accessFlag;
    }

    public byte[] getThisClass() {
        return thisClass;
    }

    public void setThisClass(byte[] thisClass) {
        this.thisClass = thisClass;
    }

    public byte[] getSuperClass() {
        return superClass;
    }

    public void setSuperClass(byte[] superClass) {
        this.superClass = superClass;
    }

    public byte[] getInterfacesCount() {
        return interfacesCount;
    }

    public void setInterfacesCount(byte[] interfacesCount) {
        this.interfacesCount = interfacesCount;
    }

    public Interfaces[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Interfaces[] interfaces) {
        this.interfaces = interfaces;
    }

    public byte[] getFieldsCount() {
        return fieldsCount;
    }

    public void setFieldsCount(byte[] fieldsCount) {
        this.fieldsCount = fieldsCount;
    }

    public byte[] getMethodsCount() {
        return methodsCount;
    }

    public void setMethodsCount(byte[] methodsCount) {
        this.methodsCount = methodsCount;
    }

    public byte[] getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(byte[] attributesCount) {
        this.attributesCount = attributesCount;
    }

    public FieldInformation[] getFieldInformation() {
        return fieldInformation;
    }

    public void setFieldInformation(FieldInformation[] fieldInformation) {
        this.fieldInformation = fieldInformation;
    }

    public MethodInformation[] getMethodInformation() {
        return methodInformation;
    }

    public void setMethodInformation(MethodInformation[] methodInformation) {
        this.methodInformation = methodInformation;
    }

    public AttributeInformation[] getAttributeInformation() {
        return attributeInformation;
    }

    public void setAttributeInformation(AttributeInformation[] attributeInformation) {
        this.attributeInformation = attributeInformation;
    }
}