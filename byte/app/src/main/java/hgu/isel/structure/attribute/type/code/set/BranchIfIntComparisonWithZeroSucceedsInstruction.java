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
public class BranchIfIntComparisonWithZeroSucceedsInstruction implements Instruction {
    private byte format;
    private byte branchByte1;
    private byte branchByte2;

    public BranchIfIntComparisonWithZeroSucceedsInstruction(byte format, byte branchByte1, byte branchByte2) {
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n            - if<cond> instruction: ");

        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", branchByte1));
        stringBuilder.append(String.format("%02X", branchByte2));

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Branch If Integer Comparison With Zero Succeeds Instruction]");
        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", branchByte1));
        stringBuilder.append(String.format("%02X", branchByte2));

        output.add(stringBuilder.toString());
        return output;
    }
}
