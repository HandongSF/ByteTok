package hgu.isel.structure.attribute.type.record;

import hgu.isel.structure.attribute.AttributeInformation;

public class RecordComponentInformation {
    private byte[] nameIndex; // u2
    private byte[] descriptorIndex; // u2
    private byte[] attributesCount; // u2
    private AttributeInformation[] attributes; // attributesCount
}
