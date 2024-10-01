package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.record.RecordComponentInformation;

public class Record implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] componentsCount; // u2
    private RecordComponentInformation[] components; // componentsCount
}
