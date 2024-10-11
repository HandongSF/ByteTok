package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class BranchIfReferenceIsNullInstruction implements Instruction {
    private byte format;
    private byte branchByte1;
    private byte branchByte2;

    public BranchIfReferenceIsNullInstruction(byte format, byte branchByte1, byte branchByte2) {
        this.format = format;
        this.branchByte1 = branchByte1;
        this.branchByte2 = branchByte2;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getBranchByte1() {
        return branchByte1;
    }

    public void setBranchByte1(byte branchByte1) {
        this.branchByte1 = branchByte1;
    }

    public byte getBranchByte2() {
        return branchByte2;
    }

    public void setBranchByte2(byte branchByte2) {
        this.branchByte2 = branchByte2;
    }
}
