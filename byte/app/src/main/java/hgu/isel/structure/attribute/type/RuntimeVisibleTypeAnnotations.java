package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.annotation.TypeAnnotation;
import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;

import java.util.ArrayList;
import java.util.List;

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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n        - RuntimeVisibleTypeAnnotations: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : numberOfAnnotations) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(TypeAnnotation t : annotations) {
            stringBuilder.append(t.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Runtime Visible Type Annotation Attribute Name Index]");
        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.add("[Runtime Visible Type Annotation Attribute Length]");
        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.add("[Runtime Visible Type Annotation Attribute Annotation Number]");
        for(byte b : numberOfAnnotations) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(TypeAnnotation c : annotations) {
            output.addAll(c.tokenize());
        }

        return output;
    }
}
