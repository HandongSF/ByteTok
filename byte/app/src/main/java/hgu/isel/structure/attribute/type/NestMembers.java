package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.nest.Classes;

public class NestMembers implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] numberOfClasses; // u2
    private Classes[] classes; // numberOfClasses

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

    public byte[] getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(byte[] numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public Classes[] getClasses() {
        return classes;
    }

    public void setClasses(Classes[] classes) {
        this.classes = classes;
    }

    public NestMembers(byte[] attributeNameIndex, byte[] attributeLength, byte[] numberOfClasses, Classes[] classes) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.numberOfClasses = numberOfClasses;
        this.classes = classes;
    }
}
