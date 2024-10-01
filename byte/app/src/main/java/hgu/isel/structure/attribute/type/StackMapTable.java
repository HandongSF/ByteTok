package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;

public class StackMapTable implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] numberOfEntries; // u2
    private StackMapFrame[] entries; // numberOfEntries
}
