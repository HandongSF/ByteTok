package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

public class IncrementLocalVariableByConstantInstruction implements Instruction {
    private byte format;
    private byte index;
    private byte constValue;

    public IncrementLocalVariableByConstantInstruction(byte format, byte index, byte constValue) {
        this.format = format;
        this.index = index;
        this.constValue = constValue;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
    }

    public byte getConstValue() {
        return constValue;
    }

    public void setConstValue(byte constValue) {
        this.constValue = constValue;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n            - iinc instruction: ");

        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", index));
        stringBuilder.append(String.format("%02X", constValue));


        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        output.add("[Increment Local Variable by Constant Instruction]");
        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", index));
        stringBuilder.append(String.format("%02X", constValue));

        output.add(stringBuilder.toString());
        return output;
    }
}
