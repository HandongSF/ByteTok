package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class IntegerInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] bytes = new byte[4]; // u4

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public IntegerInformation(byte tag, byte[] bytes) {
        this.tag = tag;
        this.bytes = bytes;
    }
}
