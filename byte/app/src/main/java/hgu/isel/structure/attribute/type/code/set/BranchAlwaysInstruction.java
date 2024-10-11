package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class BranchAlwaysInstruction implements Instruction {
    private byte format;
    private byte branchType1;
    private byte branchType2;

    public BranchAlwaysInstruction(byte format, byte branchType1, byte branchType2) {
        this.format = format;
        this.branchType1 = branchType1;
        this.branchType2 = branchType2;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getBranchType1() {
        return branchType1;
    }

    public void setBranchType1(byte branchType1) {
        this.branchType1 = branchType1;
    }

    public byte getBranchType2() {
        return branchType2;
    }

    public void setBranchType2(byte branchType2) {
        this.branchType2 = branchType2;
    }
}
