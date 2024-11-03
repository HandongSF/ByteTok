package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

public class PushItemFromRunTimeConstantPoolInstruction implements Instruction {
    private byte format;
    private byte index;

    public PushItemFromRunTimeConstantPoolInstruction(byte format, byte index) {
        this.format = format;
        this.index = index;
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n              - ldc instruction: ");

        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", index));



        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Push Item From Runtime Constant Pool Instruction] ");
        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", index));


        output.add(stringBuilder.toString());




        return output;
    }
}
