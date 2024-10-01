package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;

public class BootstrapMethods implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] numberOfBootstrapMethods; // u2
    private BootstrapMethodInformation[] bootstrapMethods; // numberOfBootstrapMethods
}
