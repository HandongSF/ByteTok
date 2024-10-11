package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class ThrowExceptionInstruction implements Instruction { // athrow
    private byte format;

    public ThrowExceptionInstruction(byte format) {
        this.format = format;
    }

    public byte getAThrow() {
        return format;
    }

    public void setAThrow(byte aThrow) {
        this.format = aThrow;
    }
}
