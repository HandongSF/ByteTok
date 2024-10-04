package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;

public class BootstrapMethods implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] numberOfBootstrapMethods; // u2
    private BootstrapMethodInformation[] bootstrapMethods; // numberOfBootstrapMethods

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

    public byte[] getNumberOfBootstrapMethods() {
        return numberOfBootstrapMethods;
    }

    public void setNumberOfBootstrapMethods(byte[] numberOfBootstrapMethods) {
        this.numberOfBootstrapMethods = numberOfBootstrapMethods;
    }

    public BootstrapMethodInformation[] getBootstrapMethods() {
        return bootstrapMethods;
    }

    public void setBootstrapMethods(BootstrapMethodInformation[] bootstrapMethods) {
        this.bootstrapMethods = bootstrapMethods;
    }

    public BootstrapMethods(byte[] attributeNameIndex, byte[] attributeLength, byte[] numberOfBootstrapMethods, BootstrapMethodInformation[] bootstrapMethods) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.numberOfBootstrapMethods = numberOfBootstrapMethods;
        this.bootstrapMethods = bootstrapMethods;
    }
}
