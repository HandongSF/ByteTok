package hgu.isel.analyzer;

import hgu.isel.structure.attribute.AttributeInformation;
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
    private FieldInformation fieldInformation;
    private byte[] methodsCount = new byte[2]; // u2
    private MethodInformation methodInformation;
    private byte[] attributesCount = new byte[2]; // u2
    private AttributeInformation attributeInformation;
    private int offset = 0;

    public ByteAnalyzer(byte[] bytes) {
        this.bytes = bytes;
    }

    public void analyze() {

        analyzeMagicNumber();
        analyzeMinorVersion();
        analyzeMajorVersion();
        analyzeConstantPoolCount();

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
        System.out.println(offset);
    }


    public void check(byte[] input) {
        for(byte s : input) {
            System.out.printf("%02X", s);
        }
        System.out.println();
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

    public FieldInformation getFieldInformation() {
        return fieldInformation;
    }

    public void setFieldInformation(FieldInformation fieldInformation) {
        this.fieldInformation = fieldInformation;
    }

    public byte[] getMethodsCount() {
        return methodsCount;
    }

    public void setMethodsCount(byte[] methodsCount) {
        this.methodsCount = methodsCount;
    }

    public MethodInformation getMethodInformation() {
        return methodInformation;
    }

    public void setMethodInformation(MethodInformation methodInformation) {
        this.methodInformation = methodInformation;
    }

    public byte[] getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(byte[] attributesCount) {
        this.attributesCount = attributesCount;
    }

    public AttributeInformation getAttributeInformation() {
        return attributeInformation;
    }

    public void setAttributeInformation(AttributeInformation attributeInformation) {
        this.attributeInformation = attributeInformation;
    }
}











































