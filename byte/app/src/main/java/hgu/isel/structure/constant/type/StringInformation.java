package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

import java.util.ArrayList;
import java.util.List;

public class StringInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] stringIndex; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getStringIndex() {
        return stringIndex;
    }

    public void setStringIndex(byte[] stringIndex) {
        this.stringIndex = stringIndex;
    }

    public StringInformation(byte tag, byte[] stringIndex) {
        this.tag = tag;
        this.stringIndex = stringIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n    - StringInformation: ");
        stringBuilder.append(String.format("%02X", tag));

        for(byte b : stringIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add(String.format("%02X", tag));

        for(byte b : stringIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());


        return output;
    }
}
