package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class LookUpSwitchInstruction implements Instruction {
    private byte format;
    private byte[] paddingByte; // 0x00으로 채워짐
    // format이 4바이트 경계에 위치하도록 해야함
    private byte defaultByte1;
    private byte defaultByte2;
    private byte defaultByte3;
    private byte defaultByte4;
    private byte nPairs1;
    private byte nPairs2;
    private byte nPairs3;
    private byte nPairs4;
    private byte[] matchOffsetPairs; // nPairs의 수에 따라 offset pairs의 수가 결정됨

    public LookUpSwitchInstruction(byte format, byte[] paddingByte, byte defaultByte1, byte defaultByte2, byte defaultByte3, byte defaultByte4, byte nPairs1, byte nPairs2, byte nPairs3, byte nPairs4, byte[] matchOffsetPairs) {
        this.format = format;
        this.paddingByte = paddingByte;
        this.defaultByte1 = defaultByte1;
        this.defaultByte2 = defaultByte2;
        this.defaultByte3 = defaultByte3;
        this.defaultByte4 = defaultByte4;
        this.nPairs1 = nPairs1;
        this.nPairs2 = nPairs2;
        this.nPairs3 = nPairs3;
        this.nPairs4 = nPairs4;
        this.matchOffsetPairs = matchOffsetPairs;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte[] getPaddingByte() {
        return paddingByte;
    }

    public void setPaddingByte(byte[] paddingByte) {
        this.paddingByte = paddingByte;
    }

    public byte getDefaultByte1() {
        return defaultByte1;
    }

    public void setDefaultByte1(byte defaultByte1) {
        this.defaultByte1 = defaultByte1;
    }

    public byte getDefaultByte2() {
        return defaultByte2;
    }

    public void setDefaultByte2(byte defaultByte2) {
        this.defaultByte2 = defaultByte2;
    }

    public byte getDefaultByte3() {
        return defaultByte3;
    }

    public void setDefaultByte3(byte defaultByte3) {
        this.defaultByte3 = defaultByte3;
    }

    public byte getDefaultByte4() {
        return defaultByte4;
    }

    public void setDefaultByte4(byte defaultByte4) {
        this.defaultByte4 = defaultByte4;
    }

    public byte getnPairs1() {
        return nPairs1;
    }

    public void setnPairs1(byte nPairs1) {
        this.nPairs1 = nPairs1;
    }

    public byte getnPairs2() {
        return nPairs2;
    }

    public void setnPairs2(byte nPairs2) {
        this.nPairs2 = nPairs2;
    }

    public byte getnPairs3() {
        return nPairs3;
    }

    public void setnPairs3(byte nPairs3) {
        this.nPairs3 = nPairs3;
    }

    public byte getnPairs4() {
        return nPairs4;
    }

    public void setnPairs4(byte nPairs4) {
        this.nPairs4 = nPairs4;
    }

    public byte[] getMatchOffsetPairs() {
        return matchOffsetPairs;
    }

    public void setMatchOffsetPairs(byte[] matchOffsetPairs) {
        this.matchOffsetPairs = matchOffsetPairs;
    }
}
