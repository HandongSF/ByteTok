package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;
import hgu.isel.structure.attribute.type.local.LocalVariableTableInformation;
import hgu.isel.structure.attribute.type.local.LocalVariableTypeTableInformation;

import java.util.ArrayList;
import java.util.List;

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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n        - LocalVariableTypeTable: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : localVariableTypeTableLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(LocalVariableTypeTableInformation l : localVariableTypeTable) {
            stringBuilder.append(l.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Local Variable Type Table Attribute Name Index]");
        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Local Variable Type Table Attribute Length]");
        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Local Variable Type Table Attribute Table Length]");
        for(byte b : localVariableTypeTableLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(LocalVariableTypeTableInformation l : localVariableTypeTable) {
            output.addAll(l.tokenize());
        }



        return output;
    }
}
