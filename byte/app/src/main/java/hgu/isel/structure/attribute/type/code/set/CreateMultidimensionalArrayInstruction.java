package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class CreateMultidimensionalArrayInstruction implements Instruction {
    private byte format;
    private byte indexByte1;
    private byte indexByte2;
    private byte dimensions;

    public CreateMultidimensionalArrayInstruction(byte format, byte indexByte1, byte indexByte2, byte dimensions) {
        this.format = format;
        this.indexByte1 = indexByte1;
        this.indexByte2 = indexByte2;
        this.dimensions = dimensions;
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

    public byte getDimensions() {
        return dimensions;
    }

    public void setDimensions(byte dimensions) {
        this.dimensions = dimensions;
    }
}