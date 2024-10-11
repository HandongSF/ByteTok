package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class DuplicateTopOneOrTwoOperandInstruction implements Instruction {
    private byte format;

    public DuplicateTopOneOrTwoOperandInstruction(byte format) {
        this.format = format;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }
}
