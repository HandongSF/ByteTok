package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

public class NewArrayInstruction implements Instruction {
    private byte format;
    private byte type;

    public NewArrayInstruction(byte format, byte type) {
        this.format = format;
        this.type = type;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n            - newarray instruction: ");

        stringBuilder.append(String.format("%02X", format));


        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        output.add(String.format("%02X", format));
        output.add(String.format("%02X", type));



        return output;
    }
}
