package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class IncrementLocalVariableByConstantInstruction implements Instruction {
    private byte format;
    private byte index;
    private byte constValue;

    public IncrementLocalVariableByConstantInstruction(byte format, byte index, byte constValue) {
        this.format = format;
        this.index = index;
        this.constValue = constValue;
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

    public byte getConstValue() {
        return constValue;
    }

    public void setConstValue(byte constValue) {
        this.constValue = constValue;
    }
}
