package hgu.isel.structure.attribute.type.code.set;

public class PushDoubleInstruction {
    private byte format;

    public PushDoubleInstruction(byte format) {
        this.format = format;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }
}
