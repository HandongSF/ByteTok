package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;

public class ConstantValue implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] constantValueIndex; // u2

    public byte[] getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(byte[] attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public byte[] getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(byte[] attributeLength) {
        this.attributeLength = attributeLength;
    }

    public byte[] getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(byte[] constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }

    public ConstantValue(byte[] attributeNameIndex, byte[] attributeLength, byte[] constantValueIndex) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.constantValueIndex = constantValueIndex;
    }
}
