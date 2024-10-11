package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class TableSwitchInstruction implements Instruction {
    private byte format;
    private byte[] paddingBytes;
    private byte defaultByte1;
    private byte defaultByte2;
    private byte defaultByte3;
    private byte defaultByte4;
    private byte lowByte1;
    private byte lowByte2;
    private byte lowByte3;
    private byte lowByte4;
    private byte highByte1;
    private byte highByte2;
    private byte highByte3;
    private byte highByte4;
    private byte[] jumpOffsets;

    public TableSwitchInstruction(byte format, byte[] paddingBytes, byte defaultByte1, byte defaultByte2, byte defaultByte3, byte defaultByte4, byte lowByte1, byte lowByte2, byte lowByte3, byte lowByte4, byte highByte1, byte highByte2, byte highByte3, byte highByte4, byte[] jumpOffsets) {
        this.format = format;
        this.paddingBytes = paddingBytes;
        this.defaultByte1 = defaultByte1;
        this.defaultByte2 = defaultByte2;
        this.defaultByte3 = defaultByte3;
        this.defaultByte4 = defaultByte4;
        this.lowByte1 = lowByte1;
        this.lowByte2 = lowByte2;
        this.lowByte3 = lowByte3;
        this.lowByte4 = lowByte4;
        this.highByte1 = highByte1;
        this.highByte2 = highByte2;
        this.highByte3 = highByte3;
        this.highByte4 = highByte4;
        this.jumpOffsets = jumpOffsets;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte[] getPaddingBytes() {
        return paddingBytes;
    }

    public void setPaddingBytes(byte[] paddingBytes) {
        this.paddingBytes = paddingBytes;
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

    public byte getLowByte1() {
        return lowByte1;
    }

    public void setLowByte1(byte lowByte1) {
        this.lowByte1 = lowByte1;
    }

    public byte getLowByte2() {
        return lowByte2;
    }

    public void setLowByte2(byte lowByte2) {
        this.lowByte2 = lowByte2;
    }

    public byte getLowByte3() {
        return lowByte3;
    }

    public void setLowByte3(byte lowByte3) {
        this.lowByte3 = lowByte3;
    }

    public byte getLowByte4() {
        return lowByte4;
    }

    public void setLowByte4(byte lowByte4) {
        this.lowByte4 = lowByte4;
    }

    public byte getHighByte1() {
        return highByte1;
    }

    public void setHighByte1(byte highByte1) {
        this.highByte1 = highByte1;
    }

    public byte getHighByte2() {
        return highByte2;
    }

    public void setHighByte2(byte highByte2) {
        this.highByte2 = highByte2;
    }

    public byte getHighByte3() {
        return highByte3;
    }

    public void setHighByte3(byte highByte3) {
        this.highByte3 = highByte3;
    }

    public byte getHighByte4() {
        return highByte4;
    }

    public void setHighByte4(byte highByte4) {
        this.highByte4 = highByte4;
    }

    public byte[] getJumpOffsets() {
        return jumpOffsets;
    }

    public void setJumpOffsets(byte[] jumpOffsets) {
        this.jumpOffsets = jumpOffsets;
    }
}
