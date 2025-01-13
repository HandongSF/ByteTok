package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;

import java.util.List;

public class CustomDefined implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] attributes;
    @Override
    public List<String> tokenize() {
        return null;
    }

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

    public byte[] getAttributes() {
        return attributes;
    }

    public void setAttributes(byte[] attributes) {
        this.attributes = attributes;
    }

    public CustomDefined(byte[] attributeNameIndex, byte[] attributeLength, byte[] attributes) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.attributes = attributes;
    }
}
