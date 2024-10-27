package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

public class PushByteInstruction implements Instruction {
    private byte format;
    private byte pushedByte;

    public PushByteInstruction(byte format, byte pushedByte) {
        this.format = format;
        this.pushedByte = pushedByte;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getPushedByte() {
        return pushedByte;
    }

    public void setPushedByte(byte pushedByte) {
        this.pushedByte = pushedByte;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n             - bipush instruction: ");

        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", pushedByte));


        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        output.add(String.format("%02X", format));
        output.add(String.format("%02X", pushedByte));




        return output;
    }
}
