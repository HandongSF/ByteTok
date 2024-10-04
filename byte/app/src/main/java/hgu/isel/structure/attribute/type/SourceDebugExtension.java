package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;

public class SourceDebugExtension implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] debugExtension; // attributeLength

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

    public byte[] getDebugExtension() {
        return debugExtension;
    }

    public void setDebugExtension(byte[] debugExtension) {
        this.debugExtension = debugExtension;
    }

    public SourceDebugExtension(byte[] attributeNameIndex, byte[] attributeLength, byte[] debugExtension) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.debugExtension = debugExtension;
    }
}
