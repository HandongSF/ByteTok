package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

public class LoadReferenceFromNLocalVariableInstruction implements Instruction {
    private byte format;

    public LoadReferenceFromNLocalVariableInstruction(byte format) {
        this.format = format;
    }

    public byte getALoadN() {
        return format;
    }

    public void setALoadN(byte aLoadN) {
        this.format = aLoadN;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n              - aload_n instruction: ");

        stringBuilder.append(String.format("%02X", format));


        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Load Reference From N Local Variable Instruction]");
        stringBuilder.append(String.format("%02X", format));

        output.add(stringBuilder.toString());




        return output;
    }
}
