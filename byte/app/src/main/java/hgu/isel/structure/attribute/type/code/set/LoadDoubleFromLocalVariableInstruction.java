package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class LoadDoubleFromLocalVariableInstruction implements Instruction {
    private byte format;
    private byte index;

    public LoadDoubleFromLocalVariableInstruction(byte format, byte index) {
        this.format = format;
        this.index = index;
    }


    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
    }
}
