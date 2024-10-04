package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.inner.InnerClassInformation;

public class InnerClasses implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] numberOfClasses; // u2
    private InnerClassInformation[] classes; // numberOfClasses;

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

    public InnerClassInformation[] getClasses() {
        return classes;
    }

    public void setClasses(InnerClassInformation[] classes) {
        this.classes = classes;
    }

    public InnerClasses(byte[] attributeNameIndex, byte[] attributeLength, byte[] numberOfClasses, InnerClassInformation[] classes) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.numberOfClasses = numberOfClasses;
        this.classes = classes;
    }
}
