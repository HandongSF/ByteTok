package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;

import java.util.ArrayList;
import java.util.List;

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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n        - BootstrapMethods: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : numberOfBootstrapMethods) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(BootstrapMethodInformation b : bootstrapMethods) {
            stringBuilder.append(b.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Bootstrap Method Attribute Name Index]");
        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Bootstrap Method Attribute Length]");
        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Bootstrap Method Attribute Number]");
        for(byte b : numberOfBootstrapMethods) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(BootstrapMethodInformation b : bootstrapMethods) {
            for(String s : b.tokenize()) {
                // output.add("[Bootstrap Method Attribute Methods]");
                stringBuilder.append(s);
                output.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }


        return output;
    }
}
