package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;

public class SourceFile implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] sourceFileIndex; // u2

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

    public byte[] getSourceFileIndex() {
        return sourceFileIndex;
    }

    public void setSourceFileIndex(byte[] sourceFileIndex) {
        this.sourceFileIndex = sourceFileIndex;
    }

    public SourceFile(byte[] attributeNameIndex, byte[] attributeLength, byte[] sourceFileIndex) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.sourceFileIndex = sourceFileIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nSourceFile: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : sourceFileIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
