package hgu.isel.structure.attribute.type.annotation;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;
import hgu.isel.structure.attribute.type.path.TypePath;
import hgu.isel.structure.attribute.type.target.TargetInformation;

import java.util.ArrayList;
import java.util.List;

public class TypeAnnotation {
    private byte targetType;
    private TargetInformation targetInformation;
    private TypePath targetPath;
    private byte[] typeIndex; // u2
    private byte[] numberOfElementValuePairs; // u2
    private ElementValuePairs[] elementValuePairs; // numberOfElementValuePairs

    public byte getTargetType() {
        return targetType;
    }

    public void setTargetType(byte targetType) {
        this.targetType = targetType;
    }

    public TargetInformation getTargetInformation() {
        return targetInformation;
    }

    public void setTargetInformation(TargetInformation targetInformation) {
        this.targetInformation = targetInformation;
    }

    public TypePath getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(TypePath targetPath) {
        this.targetPath = targetPath;
    }

    public byte[] getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(byte[] typeIndex) {
        this.typeIndex = typeIndex;
    }

    public byte[] getNumberOfElementValuePairs() {
        return numberOfElementValuePairs;
    }

    public void setNumberOfElementValuePairs(byte[] numberOfElementValuePairs) {
        this.numberOfElementValuePairs = numberOfElementValuePairs;
    }

    public ElementValuePairs[] getElementValuePairs() {
        return elementValuePairs;
    }

    public void setElementValuePairs(ElementValuePairs[] elementValuePairs) {
        this.elementValuePairs = elementValuePairs;
    }

    public TypeAnnotation(byte targetType, TargetInformation targetInformation, TypePath targetPath, byte[] typeIndex, byte[] numberOfElementValuePairs, ElementValuePairs[] elementValuePairs) {
        this.targetType = targetType;
        this.targetInformation = targetInformation;
        this.targetPath = targetPath;
        this.typeIndex = typeIndex;
        this.numberOfElementValuePairs = numberOfElementValuePairs;
        this.elementValuePairs = elementValuePairs;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", targetType));
        stringBuilder.append(targetInformation.toString());
        stringBuilder.append(targetPath.toString());

        for(byte b : typeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : numberOfElementValuePairs) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(ElementValuePairs e : elementValuePairs) {
            stringBuilder.append(e.toString());
        }

        return stringBuilder.toString();
    }


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add(String.format("%02X", targetType));
        output.addAll(targetInformation.tokenize());
        output.addAll(targetPath.tokenize());

        for(byte b : typeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : numberOfElementValuePairs) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(ElementValuePairs c : elementValuePairs) {
            output.addAll(c.tokenize());
        }

        return output;
    }
}
