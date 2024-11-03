package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;
import hgu.isel.structure.attribute.type.inner.InnerClassInformation;

import java.util.ArrayList;
import java.util.List;

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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n        - InnerClasses: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : numberOfClasses) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(InnerClassInformation i : classes) {
            stringBuilder.append(i.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[Inner Class Attribute Name Index] ");
        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        stringBuilder.append("[Inner Class Attribute Length] ");
        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        stringBuilder.append("[Inner Class Attribute Class Number] ");
        for(byte b : numberOfClasses) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(InnerClassInformation i : classes) {
            output.addAll(i.tokenize());
        }


        return output;
    }
}
