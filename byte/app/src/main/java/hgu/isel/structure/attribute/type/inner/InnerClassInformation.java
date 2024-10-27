package hgu.isel.structure.attribute.type.inner;

import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;

import java.util.ArrayList;
import java.util.List;

public class InnerClassInformation {
    private byte[] innerClassInformationIndex; // u2
    private byte[] outerClassInformationIndex; // u2
    private byte[] innerNameIndex; // u2
    private byte[] innerClassAccessFlags; // u2

    public byte[] getInnerClassInformationIndex() {
        return innerClassInformationIndex;
    }

    public void setInnerClassInformationIndex(byte[] innerClassInformationIndex) {
        this.innerClassInformationIndex = innerClassInformationIndex;
    }

    public byte[] getOuterClassInformationIndex() {
        return outerClassInformationIndex;
    }

    public void setOuterClassInformationIndex(byte[] outerClassInformationIndex) {
        this.outerClassInformationIndex = outerClassInformationIndex;
    }

    public byte[] getInnerNameIndex() {
        return innerNameIndex;
    }

    public void setInnerNameIndex(byte[] innerNameIndex) {
        this.innerNameIndex = innerNameIndex;
    }

    public byte[] getInnerClassAccessFlags() {
        return innerClassAccessFlags;
    }

    public void setInnerClassAccessFlags(byte[] innerClassAccessFlags) {
        this.innerClassAccessFlags = innerClassAccessFlags;
    }

    public InnerClassInformation(byte[] innerClassInformationIndex, byte[] outerClassInformationIndex, byte[] innerNameIndex, byte[] innerClassAccessFlags) {
        this.innerClassInformationIndex = innerClassInformationIndex;
        this.outerClassInformationIndex = outerClassInformationIndex;
        this.innerNameIndex = innerNameIndex;
        this.innerClassAccessFlags = innerClassAccessFlags;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : innerClassInformationIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : outerClassInformationIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b: innerNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : innerClassAccessFlags) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : innerClassInformationIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : outerClassInformationIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : innerNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : innerClassAccessFlags) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);


        return output;
    }
}
