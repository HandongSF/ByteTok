package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.line.LineNumberTableInformation;

public class LineNumberTable implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] lineNumberTableLength; // u2
    private LineNumberTableInformation[] lineNumberTable; // lineNumberTableLength
}
