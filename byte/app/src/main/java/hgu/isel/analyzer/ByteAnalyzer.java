package hgu.isel.analyzer;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.*;
import hgu.isel.structure.attribute.type.Deprecated;
import hgu.isel.structure.attribute.type.annotation.ElementValue;
import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;
import hgu.isel.structure.attribute.type.annotation.elemet.union.*;
import hgu.isel.structure.attribute.type.exception.ExceptionIndexTable;
import hgu.isel.structure.attribute.type.exception.ExceptionTable;
import hgu.isel.structure.attribute.type.inner.InnerClassInformation;
import hgu.isel.structure.attribute.type.line.LineNumberTableInformation;
import hgu.isel.structure.attribute.type.local.LocalVariableTableInformation;
import hgu.isel.structure.attribute.type.local.LocalVariableTypeTableInformation;
import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.constant.type.*;
import hgu.isel.structure.field.FieldInformation;
import hgu.isel.structure.interfaces.Interfaces;
import hgu.isel.structure.method.MethodInformation;
import hgu.isel.structure.constant.ConstantPoolInformation;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

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

    public void analyze() throws Exception {

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

    }

    public void analyzeMagicNumber() {
        this.magic = Arrays.copyOfRange(bytes, 0, 4);
        check(magic);

        this.offset = offset + 4;
        System.out.println(offset);
    }

    public void analyzeMinorVersion() {
        this.minorVersion =  Arrays.copyOfRange(bytes, offset, offset + 2);
        check(minorVersion);

        this.offset = offset + 2;
        System.out.println(offset);
    }

    public void analyzeMajorVersion() {
        this.minorVersion =  Arrays.copyOfRange(bytes, offset, offset + 2);
        check(minorVersion);

        this.offset = offset + 2;
        System.out.println(offset);
    }

    public void analyzeConstantPoolCount() {
        this.constantPoolCount = Arrays.copyOfRange(bytes, offset, offset + 2);
        check(constantPoolCount);

        this.offset = offset + 2;
        this.cpCount = ((constantPoolCount[0] & 0xFF) << 8) | (constantPoolCount[1] & 0xFF); // constant pool count
        System.out.println(offset);
    }

    public void analyzeConstantPool() throws Exception {
        int count = 0;
        // 실제로 index 0이 사용되지 않기 때문에 constant pool count - 1개의 constant가 존재함
        this.constantPoolInformation = new ConstantPoolInformation[cpCount - 1];

        while(count < cpCount - 1) {
            ConstantPoolInformation information = createConstantPoolEntry();
            constantPoolInformation[count] = information;

            count++;
        }

    }

    public ConstantPoolInformation createConstantPoolEntry() throws Exception {
        int tag = bytes[offset] & 0xFF;
        ConstantPoolInformation returnInformation;

        switch (tag) {
            case 1:
                int integerLength = ((bytes[offset + 1] & 0xFF) << 8) | (bytes[offset + 2] & 0xFF);
                byte[] byteLength = Arrays.copyOfRange(bytes, offset + 1, offset + 2);
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
        check(accessFlag);

        this.offset = offset + 2;
        System.out.println(offset);
    }

    public void analyzeThisClass() {
        this.thisClass = Arrays.copyOfRange(bytes, offset, offset + 2);
        check(thisClass);

        this.offset = offset + 2;
        System.out.println(offset);
    }

    public void analyzeSuperClass() {
        this.superClass = Arrays.copyOfRange(bytes, offset, offset + 2);
        check(superClass);

        this.offset = offset + 2;
        System.out.println(offset);
    }

    public void analyzeInterfaceCount() {
        this.interfacesCount = Arrays.copyOfRange(bytes, offset, offset + 2);
        check(interfacesCount);

        this.offset = offset + 2;
        System.out.println(offset);
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
        check(fieldsCount);

        this.offset = offset + 2;
        System.out.println(offset);
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
        AttributeInformation returnInformation = null;
        int utf8Index = ((bytes[offset] & 0xFF) << 8) | (bytes[offset + 1] & 0xFF);
        UTF8Information utf8Information = (UTF8Information) constantPoolInformation[utf8Index - 1];
        // 여기서 오류가 발생하면 안됨
        // UTF8Information type으로 저장이 되어있기 때문에 type casting 오류가 발생할 수 없음

        byte[] attributeName = utf8Information.getBytes();
        // byte[]는 switch 구문을 사용할 수 없음
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

            returnInformation = new Code(attributeNameIndex, attributeLength, maxStack, maxLocals, codeLength, code, exceptionTableLength, exceptionTables, attributesCount, attributes);

        } else if(Arrays.equals(attributeName, "StackMapTable".getBytes("UTF-8"))) { // 이거 좀 나중에 하자
//            byte[] numberOfEntries = Arrays.copyOfRange(bytes, offset, offset + 1);
//            int numberOfEntriesInteger = ((numberOfEntries[0] & 0xFF) << 8) | (numberOfEntries[1] & 0xFF);
//            offset += 2;
//
//            StackMapFrame[] stackMapFrames = new StackMapFrame[numberOfEntriesInteger];
//            int count = 0;
//
//            while(count < numberOfEntriesInteger) {
//
//                count++;
//            }

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

        } else if(Arrays.equals(attributeName, "RuntimeVisibleParameterAnnotations".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "RuntimeInvisibleParameterAnnotations".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "RuntimeVisibleTypeAnnotations".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "RuntimeInvisibleTypeAnnotations".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "AnnotationDefault".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "BootstrapMethods".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "MethodParameters".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "Module".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "ModulePackages".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "ModuleMainClass".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "NestHost".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "NestMembers".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "Record".getBytes("UTF-8"))) {

        } else if(Arrays.equals(attributeName, "PermittedSubclasses".getBytes("UTF-8"))) {

        } else {
            throw new UnsupportedEncodingException();
        }

        return returnInformation;
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











































