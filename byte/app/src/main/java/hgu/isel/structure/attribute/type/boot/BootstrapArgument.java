package hgu.isel.structure.attribute.type.boot;

import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;

public class BootstrapArgument {
    private byte[] bytes; // u2

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public BootstrapArgument(byte[] bytes) {
        this.bytes = bytes;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : bytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
