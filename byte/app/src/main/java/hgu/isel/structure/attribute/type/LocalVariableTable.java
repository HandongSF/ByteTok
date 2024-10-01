package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.local.LocalVariableTableInformation;

public class LocalVariableTable implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] localVariableTableLength; // u2
    private LocalVariableTableInformation[] localVariableTable; // localVariableTableLength
}
