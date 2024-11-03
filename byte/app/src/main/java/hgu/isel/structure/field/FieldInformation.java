package hgu.isel.structure.field;

import hgu.isel.structure.attribute.AttributeInformation;

import java.util.ArrayList;
import java.util.List;

public class FieldInformation {
    private byte[] accessFlags; // u2
    private byte[] nameIndex; // u2
    private byte[] descriptorIndex; // u2
    private byte[] attributesCount; // u2
    private AttributeInformation[] attributes; // attributesCount

    public byte[] getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(byte[] accessFlags) {
        this.accessFlags = accessFlags;
    }

    public byte[] getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(byte[] nameIndex) {
        this.nameIndex = nameIndex;
    }

    public byte[] getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(byte[] descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public byte[] getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(byte[] attributesCount) {
        this.attributesCount = attributesCount;
    }

    public AttributeInformation[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInformation[] attributes) {
        this.attributes = attributes;
    }

    public FieldInformation(byte[] accessFlags, byte[] nameIndex, byte[] descriptorIndex, byte[] attributesCount, AttributeInformation[] attributes) {
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributesCount = attributesCount;
        this.attributes = attributes;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n    Field: ");


        for(byte b : accessFlags) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : nameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : descriptorIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributesCount) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(AttributeInformation a : attributes) {
            stringBuilder.append(a.toString());
        }

        return stringBuilder.toString();
    }

    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[Field Access Flag] ");
        for(byte b : accessFlags) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        stringBuilder.append("[Field Name Index] ");
        for(byte b : nameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        stringBuilder.append("[Field Descriptor Index] ");
        for(byte b : descriptorIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        stringBuilder.append("[Field Attribute Count] ");
        for(byte b : attributesCount) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(AttributeInformation a : attributes) {
            for(String s : a.tokenize()) {
                stringBuilder.append("[Field Attribute] ");
                stringBuilder.append(s);

                output.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }

        }

        return output;
    }
}
