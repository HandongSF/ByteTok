package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;

public class ConstantValue implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] constantValueIndex; // u2
}
