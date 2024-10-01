package hgu.isel.structure.field;

import hgu.isel.structure.attribute.AttributeInformation;

public class FieldInformation {
    private byte[] accessFlags; // u2
    private byte[] nameIndex; // u2
    private byte[] descriptorIndex; // u2
    private byte[] attributesCount; // u2
    private AttributeInformation attributes; // attributesCount
}
