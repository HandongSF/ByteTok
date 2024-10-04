package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.record.RecordComponentInformation;

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
}
