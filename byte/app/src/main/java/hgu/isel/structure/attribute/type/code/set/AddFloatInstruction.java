package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class AddFloatInstruction implements Instruction {
    private byte format;

    public AddFloatInstruction(byte format) {
        this.format = format;
    }

    public byte getFadD() {
        return format;
    }

    public void setFadD(byte format) {
        this.format = format;
    }
}
