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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n            - goto instruction: ");

        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", branchType1));
        stringBuilder.append(String.format("%02X", branchType2));

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Branch Always Instruction]");
        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", branchType1));
        stringBuilder.append(String.format("%02X", branchType2));

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
