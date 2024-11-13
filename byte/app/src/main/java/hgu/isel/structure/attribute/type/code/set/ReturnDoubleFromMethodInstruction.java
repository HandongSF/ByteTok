package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

public class ReturnDoubleFromMethodInstruction implements Instruction {
    private byte format;

    public ReturnDoubleFromMethodInstruction(byte format) {
        this.format = format;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n              - dreturn instruction: ");

        stringBuilder.append(String.format("%02X", format));



        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        output.add("[Remainder Double From Method Instruction]");
        stringBuilder.append(String.format("%02X", format));



        output.add(stringBuilder.toString());




        return output;
    }
}
