package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class WideWithLINCInstruction implements Instruction {
    private byte format;
    private IncrementLocalVariableByConstantInstruction instruction;
    private byte indexByte1;
    private byte indexByte2;
    private byte constByte1;
    private byte constByte2;

    public WideWithLINCInstruction(byte format, IncrementLocalVariableByConstantInstruction instruction, byte indexByte1, byte indexByte2, byte constByte1, byte constByte2) {
        this.format = format;
        this.instruction = instruction;
        this.indexByte1 = indexByte1;
        this.indexByte2 = indexByte2;
        this.constByte1 = constByte1;
        this.constByte2 = constByte2;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public IncrementLocalVariableByConstantInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(IncrementLocalVariableByConstantInstruction instruction) {
        this.instruction = instruction;
    }

    public byte getIndexByte1() {
        return indexByte1;
    }

    public void setIndexByte1(byte indexByte1) {
        this.indexByte1 = indexByte1;
    }

    public byte getIndexByte2() {
        return indexByte2;
    }

    public void setIndexByte2(byte indexByte2) {
        this.indexByte2 = indexByte2;
    }

    public byte getConstByte1() {
        return constByte1;
    }

    public void setConstByte1(byte constByte1) {
        this.constByte1 = constByte1;
    }

    public byte getConstByte2() {
        return constByte2;
    }

    public void setConstByte2(byte constByte2) {
        this.constByte2 = constByte2;
    }
}
