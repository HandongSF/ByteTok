package hgu.isel.structure.attribute.type.boot;

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
}
