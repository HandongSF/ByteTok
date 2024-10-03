package hgu.isel.analyzer;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.constant.type.*;
import hgu.isel.structure.field.FieldInformation;
import hgu.isel.structure.interfaces.Interfaces;
import hgu.isel.structure.method.MethodInformation;
import hgu.isel.structure.constant.ConstantPoolInformation;

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

    }

    public void analyzeMagicNumber() {
        this.magic = Arrays.copyOfRange(bytes, 0, 4);
//        check(magic);

        this.offset = offset + 4;
//        System.out.println(offset);
    }

    public void analyzeMinorVersion() {
        this.minorVersion =  Arrays.copyOfRange(bytes, offset, offset + 2);
//        check(minorVersion);

        this.offset = offset + 2;
//        System.out.println(offset);
    }

    public void analyzeMajorVersion() {
        this.minorVersion =  Arrays.copyOfRange(bytes, offset, offset + 2);
//        check(minorVersion);

        this.offset = offset + 2;
//        System.out.println(offset);
    }

    public void analyzeConstantPoolCount() {
        this.constantPoolCount = Arrays.copyOfRange(bytes, offset, offset + 2);
//        check(constantPoolCount);

        this.offset = offset + 2;
        this.cpCount = ((constantPoolCount[0] & 0xFF) << 8) | (constantPoolCount[1] & 0xFF); // constant pool count
//        System.out.println(offset);
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
        ConstantPoolInformation returnInformation = null;

        switch (tag) {
            case 1:
                int integerLength = ((bytes[offset + 1] & 0xFF) << 8) | (bytes[offset + 2] & 0xFF);
                byte[] byteLength = Arrays.copyOfRange(bytes, offset + 1, offset + 2);
                byte[] byteUTF = Arrays.copyOfRange(bytes, offset + 3, offset + integerLength + 3);

                returnInformation = new UTF8Information(bytes[offset], byteLength, byteUTF);
                offset = offset + 3 + integerLength;
                break;
            case 3:
                returnInformation = new IntegerInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 4));
                offset += 5;
                break;
            case 4:
                returnInformation = new FloatInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 4));
                offset += 5;
                break;
            case 5:
                returnInformation = new LongInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 4), Arrays.copyOfRange(bytes, offset + 5, offset + 8));
                offset += 9;
                break;
            case 6:
                returnInformation = new DoubleInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 4), Arrays.copyOfRange(bytes, offset + 5, offset + 8));
                offset += 9;
                break;
            case 7:
                returnInformation = new ClassInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2));
                offset += 3;
                break;
            case 8:
                returnInformation = new StringInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2));
                offset += 3;
                break;
            case 9:
                returnInformation = new FieldReferenceInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2), Arrays.copyOfRange(bytes, offset + 3, offset + 4));
                offset += 5;
                break;
            case 10:
                returnInformation = new MethodReferenceInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2), Arrays.copyOfRange(bytes, offset + 3, offset + 4));
                offset += 5;
                break;
            case 11:
                returnInformation = new InterfaceMethodReferenceInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2), Arrays.copyOfRange(bytes, offset + 3, offset + 4));
                offset += 5;
                break;
            case 12:
                returnInformation = new NameAndTypeInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2), Arrays.copyOfRange(bytes, offset + 3, offset + 4));
                offset += 5;
                break;
            case 15:
                returnInformation = new MethodHandleInformation(bytes[offset], bytes[offset + 1], Arrays.copyOfRange(bytes, offset + 2, offset + 3));
                offset += 4;
                break;
            case 16:
                returnInformation = new MethodTypeInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2));
                offset += 3;
                break;
            case 17:
                returnInformation = new DynamicInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2), Arrays.copyOfRange(bytes, offset + 3, offset + 4));
                offset += 5;
                break;
            case 18:
                returnInformation = new InvokeDynamicInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2), Arrays.copyOfRange(bytes, offset + 3, offset + 4));
                offset += 5;
                break;
            case 19:
                returnInformation = new ModuleInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2));
                offset += 3;
                break;
            case 20:
                returnInformation = new PackageInformation(bytes[offset], Arrays.copyOfRange(bytes, offset + 1, offset + 2));
                offset += 3;
                break;
            default:
                throw new Exception();
        }

        return returnInformation;

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











































