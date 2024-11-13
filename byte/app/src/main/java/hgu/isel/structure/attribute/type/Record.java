package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.nest.Classes;
import hgu.isel.structure.attribute.type.record.RecordComponentInformation;

import java.util.ArrayList;
import java.util.List;

public class Record implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] componentsCount; // u2
    private RecordComponentInformation[] components; // componentsCount

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

    public byte[] getComponentsCount() {
        return componentsCount;
    }

    public void setComponentsCount(byte[] componentsCount) {
        this.componentsCount = componentsCount;
    }

    public RecordComponentInformation[] getComponents() {
        return components;
    }

    public void setComponents(RecordComponentInformation[] components) {
        this.components = components;
    }

    public Record(byte[] attributeNameIndex, byte[] attributeLength, byte[] componentsCount, RecordComponentInformation[] components) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.componentsCount = componentsCount;
        this.components = components;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n        - Record: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : componentsCount) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(RecordComponentInformation r : components) {
            stringBuilder.append(r.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Record Attribute Name Index]");
        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.add("[Record Attribute Length]");
        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.add("[Record Attribute Components Count]");
        for(byte b : componentsCount) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(RecordComponentInformation c : components) {
            output.addAll(c.tokenize());
        }

        return output;
    }
}
