package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class AddDoubleInstruction implements Instruction {
    private byte format;

    public AddDoubleInstruction(byte format) {
        this.format = format;
    }

    public byte getDADd() {
        return format;
    }

    public void setDADd(byte format) {
        this.format = format;
    }
}
