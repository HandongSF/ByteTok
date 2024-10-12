package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class WideWithIINCInstruction implements Instruction {
    private byte format;
    private byte iinc;
    private byte indexByte1;
    private byte indexByte2;
    private byte constByte1;
    private byte constByte2;

    public WideWithIINCInstruction(byte format, byte iinc, byte indexByte1, byte indexByte2, byte constByte1, byte constByte2) {
        this.format = format;
        this.iinc = iinc;
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

    public byte getIinc() {
        return iinc;
    }

    public void setIinc(byte iinc) {
        this.iinc = iinc;
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
