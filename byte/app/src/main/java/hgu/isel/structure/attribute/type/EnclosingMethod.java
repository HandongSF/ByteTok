package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;

public class EnclosingMethod implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] classIndex; // u2
    private byte[] methodIndex; // u2

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

    public byte[] getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(byte[] classIndex) {
        this.classIndex = classIndex;
    }

    public byte[] getMethodIndex() {
        return methodIndex;
    }

    public void setMethodIndex(byte[] methodIndex) {
        this.methodIndex = methodIndex;
    }

    public EnclosingMethod(byte[] attributeNameIndex, byte[] attributeLength, byte[] classIndex, byte[] methodIndex) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.classIndex = classIndex;
        this.methodIndex = methodIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n        - EnclosingMethod: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : classIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : methodIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
