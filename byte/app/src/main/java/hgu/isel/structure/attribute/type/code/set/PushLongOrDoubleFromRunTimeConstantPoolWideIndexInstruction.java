package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class PushLongOrDoubleFromRunTimeConstantPoolWideIndexInstruction implements Instruction {
    private byte format;
    private byte indexByte1;
    private byte indexByte2;

    public PushLongOrDoubleFromRunTimeConstantPoolWideIndexInstruction(byte format, byte indexByte1, byte indexByte2) {
        this.format = format;
        this.indexByte1 = indexByte1;
        this.indexByte2 = indexByte2;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
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
}
