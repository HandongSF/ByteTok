package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.line.LineNumberTableInformation;

public class LineNumberTable implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] lineNumberTableLength; // u2
    private LineNumberTableInformation[] lineNumberTable; // lineNumberTableLength

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

    public byte[] getLineNumberTableLength() {
        return lineNumberTableLength;
    }

    public void setLineNumberTableLength(byte[] lineNumberTableLength) {
        this.lineNumberTableLength = lineNumberTableLength;
    }

    public LineNumberTableInformation[] getLineNumberTable() {
        return lineNumberTable;
    }

    public void setLineNumberTable(LineNumberTableInformation[] lineNumberTable) {
        this.lineNumberTable = lineNumberTable;
    }

    public LineNumberTable(byte[] attributeNameIndex, byte[] attributeLength, byte[] lineNumberTableLength, LineNumberTableInformation[] lineNumberTable) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.lineNumberTableLength = lineNumberTableLength;
        this.lineNumberTable = lineNumberTable;
    }
}
