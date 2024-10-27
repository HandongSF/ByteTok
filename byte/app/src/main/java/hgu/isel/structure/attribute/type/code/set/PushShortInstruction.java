package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

public class PushShortInstruction implements Instruction {
    private byte format;
    private byte byte1;
    private byte byte2;

    public PushShortInstruction(byte format, byte byte1, byte byte2) {
        this.format = format;
        this.byte1 = byte1;
        this.byte2 = byte2;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getByte1() {
        return byte1;
    }

    public void setByte1(byte byte1) {
        this.byte1 = byte1;
    }

    public byte getByte2() {
        return byte2;
    }

    public void setByte2(byte byte2) {
        this.byte2 = byte2;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n              - sipush instruction: ");

        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", byte1));
        stringBuilder.append(String.format("%02X", byte2));



        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        output.add(String.format("%02X", format));
        output.add(String.format("%02X", byte1));
        output.add(String.format("%02X", byte2));



        return output;
    }
}
