package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.annotation.TypeAnnotation;

public class RuntimeVisibleTypeAnnotations implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] numberOfAnnotations; // u2
    private TypeAnnotation[] annotations;

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

    public byte[] getNumberOfAnnotations() {
        return numberOfAnnotations;
    }

    public void setNumberOfAnnotations(byte[] numberOfAnnotations) {
        this.numberOfAnnotations = numberOfAnnotations;
    }

    public TypeAnnotation[] getAnnotations() {
        return annotations;
    }

    public void setAnnotations(TypeAnnotation[] annotations) {
        this.annotations = annotations;
    }

    public RuntimeVisibleTypeAnnotations(byte[] attributeNameIndex, byte[] attributeLength, byte[] numberOfAnnotations, TypeAnnotation[] annotations) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.numberOfAnnotations = numberOfAnnotations;
        this.annotations = annotations;
    }
}
