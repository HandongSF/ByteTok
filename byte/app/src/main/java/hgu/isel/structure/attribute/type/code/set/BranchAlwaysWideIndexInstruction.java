package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class BranchAlwaysWideIndexInstruction implements Instruction {
    private byte format;
    private byte branchType1;
    private byte branchType2;
    private byte branchType3;
    private byte branchType4;

    public BranchAlwaysWideIndexInstruction(byte format, byte branchType1, byte branchType2, byte branchType3, byte branchType4) {
        this.format = format;
        this.branchType1 = branchType1;
        this.branchType2 = branchType2;
        this.branchType3 = branchType3;
        this.branchType4 = branchType4;
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

    public byte getBranchType3() {
        return branchType3;
    }

    public void setBranchType3(byte branchType3) {
        this.branchType3 = branchType3;
    }

    public byte getBranchType4() {
        return branchType4;
    }

    public void setBranchType4(byte branchType4) {
        this.branchType4 = branchType4;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n            - goto_w instruction: ");

        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", branchType1));
        stringBuilder.append(String.format("%02X", branchType2));
        stringBuilder.append(String.format("%02X", branchType3));
        stringBuilder.append(String.format("%02X", branchType4));

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Branch Always Wide Instruction]");
        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", branchType1));
        stringBuilder.append(String.format("%02X", branchType2));
        stringBuilder.append(String.format("%02X", branchType3));
        stringBuilder.append(String.format("%02X", branchType4));


        output.add(stringBuilder.toString());
        return output;
    }
}
