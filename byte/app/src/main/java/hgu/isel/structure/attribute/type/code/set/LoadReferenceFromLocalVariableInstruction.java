package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class LoadReferenceFromLocalVariableInstruction implements Instruction {
    private byte format;
    private byte index;

    public LoadReferenceFromLocalVariableInstruction(byte format, byte index) {
        this.format = format;
        this.index = index;
    }

    public byte getALoad() {
        return format;
    }

    public void setALoad(byte aLoad) {
        this.format = aLoad;
    }

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
    }
}
