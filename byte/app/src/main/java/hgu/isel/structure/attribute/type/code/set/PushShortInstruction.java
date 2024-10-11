package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class PushShortInstruction implements Instruction {
    private byte format;
    private byte byte1;
    private byte byte2;

    public PushShortInstruction(byte format, byte byte1, byte byte2) {
        this.format = format;
        this.byte1 = byte1;
        this.byte2 = byte2;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getByte1() {
        return byte1;
    }

    public void setByte1(byte byte1) {
        this.byte1 = byte1;
    }

    public byte getByte2() {
        return byte2;
    }

    public void setByte2(byte byte2) {
        this.byte2 = byte2;
    }
}
