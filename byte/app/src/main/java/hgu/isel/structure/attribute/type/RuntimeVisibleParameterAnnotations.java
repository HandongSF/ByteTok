package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.annotation.ParameterAnnotations;

public class RuntimeVisibleParameterAnnotations implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte numberOfParameters;
    private ParameterAnnotations[] parameterAnnotations; // numberOfParameters

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

    public byte getNumberOfParameters() {
        return numberOfParameters;
    }

    public void setNumberOfParameters(byte numberOfParameters) {
        this.numberOfParameters = numberOfParameters;
    }

    public ParameterAnnotations[] getParameterAnnotations() {
        return parameterAnnotations;
    }

    public void setParameterAnnotations(ParameterAnnotations[] parameterAnnotations) {
        this.parameterAnnotations = parameterAnnotations;
    }

    public RuntimeVisibleParameterAnnotations(byte[] attributeNameIndex, byte[] attributeLength, byte numberOfParameters, ParameterAnnotations[] parameterAnnotations) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.numberOfParameters = numberOfParameters;
        this.parameterAnnotations = parameterAnnotations;
    }
}
