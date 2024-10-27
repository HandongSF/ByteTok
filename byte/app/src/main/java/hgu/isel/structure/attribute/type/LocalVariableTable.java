package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;
import hgu.isel.structure.attribute.type.local.LocalVariableTableInformation;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableTable implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] localVariableTableLength; // u2
    private LocalVariableTableInformation[] localVariableTable; // localVariableTableLength

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

    public byte[] getLocalVariableTableLength() {
        return localVariableTableLength;
    }

    public void setLocalVariableTableLength(byte[] localVariableTableLength) {
        this.localVariableTableLength = localVariableTableLength;
    }

    public LocalVariableTableInformation[] getLocalVariableTable() {
        return localVariableTable;
    }

    public void setLocalVariableTable(LocalVariableTableInformation[] localVariableTable) {
        this.localVariableTable = localVariableTable;
    }

    public LocalVariableTable(byte[] attributeNameIndex, byte[] attributeLength, byte[] localVariableTableLength, LocalVariableTableInformation[] localVariableTable) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.localVariableTableLength = localVariableTableLength;
        this.localVariableTable = localVariableTable;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n        - LocalVariableTable: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : localVariableTableLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(LocalVariableTableInformation l : localVariableTable) {
            stringBuilder.append(l.toString());
        }

        return stringBuilder.toString();
    }
    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : localVariableTableLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(LocalVariableTableInformation l : localVariableTable) {
            output.addAll(l.tokenize());
        }



        return output;
    }
}
