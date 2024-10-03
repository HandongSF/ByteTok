package hgu.isel.structure.interfaces;

public class Interfaces {
    private byte[] bytes = new byte[2]; // u2

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Interfaces(byte[] bytes) {
        this.bytes = bytes;
    }
}
