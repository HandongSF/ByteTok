package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class NewArrayInstruction implements Instruction {
    private byte format;
    private byte type;

    public NewArrayInstruction(byte format, byte type) {
        this.format = format;
        this.type = type;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}
