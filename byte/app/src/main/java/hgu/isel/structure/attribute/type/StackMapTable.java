package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;
import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;

public class StackMapTable implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] numberOfEntries; // u2
    private StackMapFrame[] entries; // numberOfEntries

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

    public byte[] getNumberOfEntries() {
        return numberOfEntries;
    }

    public void setNumberOfEntries(byte[] numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    public StackMapFrame[] getEntries() {
        return entries;
    }

    public void setEntries(StackMapFrame[] entries) {
        this.entries = entries;
    }

    public StackMapTable(byte[] attributeNameIndex, byte[] attributeLength, byte[] numberOfEntries, StackMapFrame[] entries) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.numberOfEntries = numberOfEntries;
        this.entries = entries;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nStackMapTable: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : numberOfEntries) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(StackMapFrame s : entries) {
            stringBuilder.append(s.toString());
        }

        return stringBuilder.toString();
    }
}
