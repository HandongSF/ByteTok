package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.local.LocalVariableTypeTableInformation;

public class LocalVariableTypeTable implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] localVariableTypeTableLength; // u2
    private LocalVariableTypeTableInformation[] localVariableTypeTable; // localVariableTypeTableLength

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

    public byte[] getLocalVariableTypeTableLength() {
        return localVariableTypeTableLength;
    }

    public void setLocalVariableTypeTableLength(byte[] localVariableTypeTableLength) {
        this.localVariableTypeTableLength = localVariableTypeTableLength;
    }

    public LocalVariableTypeTableInformation[] getLocalVariableTypeTable() {
        return localVariableTypeTable;
    }

    public void setLocalVariableTypeTable(LocalVariableTypeTableInformation[] localVariableTypeTable) {
        this.localVariableTypeTable = localVariableTypeTable;
    }

    public LocalVariableTypeTable(byte[] attributeNameIndex, byte[] attributeLength, byte[] localVariableTypeTableLength, LocalVariableTypeTableInformation[] localVariableTypeTable) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.localVariableTypeTableLength = localVariableTypeTableLength;
        this.localVariableTypeTable = localVariableTypeTable;
    }
}
