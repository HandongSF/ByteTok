package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class UTF8Information implements ConstantPoolInformation {
    private byte tag;
    private byte[] length; // u2
    private byte[] bytes; // length

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getLength() {
        return length;
    }

    public void setLength(byte[] length) {
        this.length = length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public UTF8Information(byte tag, byte[] length, byte[] bytes) {
        this.tag = tag;
        this.length = length;
        this.bytes = bytes;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n    - UTF8Information: ");
        stringBuilder.append(String.format("%02X", tag));

        for(byte b : length) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : bytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
