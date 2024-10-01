package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.local.LocalVariableTypeTableInformation;

public class LocalVariableTypeTable implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] localVariableTypeTableLength; // u2
    private LocalVariableTypeTableInformation[] localVariableTypeTable; // localVariableTypeTableLength
}
