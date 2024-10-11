package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class PushNullInstruction implements Instruction {
    private byte format;

    public PushNullInstruction(byte format) {
        this.format = format;
    }

    public byte getAConstNull() {
        return format;
    }

    public void setAConstNull(byte aConstNull) {
        this.format = aConstNull;
    }
}
