package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class PushByteInstruction implements Instruction {
    private byte format;
    private byte pushedByte;

    public PushByteInstruction(byte format, byte pushedByte) {
        this.format = format;
        this.pushedByte = pushedByte;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getPushedByte() {
        return pushedByte;
    }

    public void setPushedByte(byte pushedByte) {
        this.pushedByte = pushedByte;
    }
}
