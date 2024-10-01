package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.annotation.ParameterAnnotations;

public class RuntimeVisibleParameterAnnotations implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte numberOfParameters;
    private ParameterAnnotations[] parameterAnnotations; // numberOfParameters
}
