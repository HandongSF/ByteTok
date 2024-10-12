package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class DivideIntInstruction implements Instruction {
    private byte format;

    public DivideIntInstruction(byte format) {
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

        stringBuilder.append("\n            - idiv instruction: ");

        stringBuilder.append(String.format("%02X", format));


        return stringBuilder.toString();
    }
}
