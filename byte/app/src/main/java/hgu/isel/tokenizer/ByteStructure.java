package hgu.isel.tokenizer;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.constant.ConstantPoolInformation;
import hgu.isel.structure.field.FieldInformation;
import hgu.isel.structure.interfaces.Interfaces;
import hgu.isel.structure.method.MethodInformation;

public class ByteStructure {
    private String fileName;
    private byte[] magic;
    private byte[] minorVersion;
    private byte[] majorVersion;
    private byte[] constantPoolCount;
    private ConstantPoolInformation[] constantPoolInformation;
    private byte[] accessFlag;
    private byte[] thisClass;
    private byte[] superClass;
    private byte[] interfacesCount;
    private Interfaces[] interfaces; // interfacesCount
    private byte[] fieldsCount;
    private FieldInformation[] fieldInformation;
    private byte[] methodsCount;
    private MethodInformation[] methodInformation;
    private byte[] attributesCount;
    private AttributeInformation[] attributeInformation;

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

    public FieldInformation[] getFieldInformation() {
        return fieldInformation;
    }

    public void setFieldInformation(FieldInformation[] fieldInformation) {
        this.fieldInformation = fieldInformation;
    }

    public byte[] getMethodsCount() {
        return methodsCount;
    }

    public void setMethodsCount(byte[] methodsCount) {
        this.methodsCount = methodsCount;
    }

    public MethodInformation[] getMethodInformation() {
        return methodInformation;
    }

    public void setMethodInformation(MethodInformation[] methodInformation) {
        this.methodInformation = methodInformation;
    }

    public byte[] getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(byte[] attributesCount) {
        this.attributesCount = attributesCount;
    }

    public AttributeInformation[] getAttributeInformation() {
        return attributeInformation;
    }

    public void setAttributeInformation(AttributeInformation[] attributeInformation) {
        this.attributeInformation = attributeInformation;
    }

    public ByteStructure(byte[] magic, byte[] minorVersion, byte[] majorVersion, byte[] constantPoolCount, ConstantPoolInformation[] constantPoolInformation, byte[] accessFlag, byte[] thisClass, byte[] superClass, byte[] interfacesCount, Interfaces[] interfaces, byte[] fieldsCount, FieldInformation[] fieldInformation, byte[] methodsCount, MethodInformation[] methodInformation, byte[] attributesCount, AttributeInformation[] attributeInformation) {
        this.magic = magic;
        this.minorVersion = minorVersion;
        this.majorVersion = majorVersion;
        this.constantPoolCount = constantPoolCount;
        this.constantPoolInformation = constantPoolInformation;
        this.accessFlag = accessFlag;
        this.thisClass = thisClass;
        this.superClass = superClass;
        this.interfacesCount = interfacesCount;
        this.interfaces = interfaces;
        this.fieldsCount = fieldsCount;
        this.fieldInformation = fieldInformation;
        this.methodsCount = methodsCount;
        this.methodInformation = methodInformation;
        this.attributesCount = attributesCount;
        this.attributeInformation = attributeInformation;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
