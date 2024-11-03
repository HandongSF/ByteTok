package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

public class JumpSubroutineWideIndexInstruction implements Instruction {
    private byte format;
    private byte branchByte1;
    private byte branchByte2;
    private byte branchByte3;
    private byte branchByte4;

    public JumpSubroutineWideIndexInstruction(byte format, byte branchByte1, byte branchByte2, byte branchByte3, byte branchByte4) {
        this.format = format;
        this.branchByte1 = branchByte1;
        this.branchByte2 = branchByte2;
        this.branchByte3 = branchByte3;
        this.branchByte4 = branchByte4;
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

    public byte getBranchByte3() {
        return branchByte3;
    }

    public void setBranchByte3(byte branchByte3) {
        this.branchByte3 = branchByte3;
    }

    public byte getBranchByte4() {
        return branchByte4;
    }

    public void setBranchByte4(byte branchByte4) {
        this.branchByte4 = branchByte4;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n              - jsr_w instruction: ");

        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", branchByte1));
        stringBuilder.append(String.format("%02X", branchByte2));
        stringBuilder.append(String.format("%02X", branchByte3));
        stringBuilder.append(String.format("%02X", branchByte4));


        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Jump Subroutine Wide Instruction] ");
        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", branchByte1));
        stringBuilder.append(String.format("%02X", branchByte2));
        stringBuilder.append(String.format("%02X", branchByte3));
        stringBuilder.append(String.format("%02X", branchByte4));

        output.add(stringBuilder.toString());

        return output;
    }
}
