package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class LoadReferenceFromNLocalVariableInstruction implements Instruction {
    private byte format;

    public LoadReferenceFromNLocalVariableInstruction(byte format) {
        this.format = format;
    }

    public byte getALoadN() {
        return format;
    }

    public void setALoadN(byte aLoadN) {
        this.format = aLoadN;
    }
}
