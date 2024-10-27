package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

public class ReturnReferenceFromMethodInstruction implements Instruction {
    private byte format;

    public ReturnReferenceFromMethodInstruction(byte format) {
        this.format = format;
    }

    public byte getAReturn() {
        return format;
    }

    public void setAReturn(byte aReturn) {
        this.format = aReturn;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n           - areturn instruction: ");

        stringBuilder.append(String.format("%02X", format));



        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        output.add(String.format("%02X", format));




        return output;
    }
}
