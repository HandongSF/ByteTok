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
public class InvokeInterfaceInstruction implements Instruction {
    private byte format;
    private byte indexByte1;
    private byte indexByte2;
    private byte count;
    private final byte ignoreNum = 0;

    public InvokeInterfaceInstruction(byte format, byte indexByte1, byte indexByte2, byte count) {
        this.format = format;
        this.indexByte1 = indexByte1;
        this.indexByte2 = indexByte2;
        this.count = count;
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

    public byte getCount() {
        return count;
    }

    public void setCount(byte count) {
        this.count = count;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n            - invokeinterface instruction: ");

        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", indexByte1));
        stringBuilder.append(String.format("%02X", indexByte2));
        stringBuilder.append(String.format("%02X", count));


        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Invoke Interface Instruction]");
        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", indexByte1));
        stringBuilder.append(String.format("%02X", indexByte2));
        stringBuilder.append(String.format("%02X", count));
        stringBuilder.append(String.format("%02X", ignoreNum));

        output.add(stringBuilder.toString());
        return output;
    }
}
