package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

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
        return "StringInformation";
    }
}
