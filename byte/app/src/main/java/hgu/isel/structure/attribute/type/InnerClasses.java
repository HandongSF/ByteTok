package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.inner.InnerClassInformation;

public class InnerClasses implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] numberOfClasses; // u2
    private InnerClassInformation[] classes; // numberOfClasses;
}
