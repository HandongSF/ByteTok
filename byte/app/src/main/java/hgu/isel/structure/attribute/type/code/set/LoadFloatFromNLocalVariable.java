package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class LoadFloatFromNLocalVariable implements Instruction {
    private byte format;

    public LoadFloatFromNLocalVariable(byte format) {
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

        stringBuilder.append("\n            - fload_n instruction: ");

        stringBuilder.append(String.format("%02X", format));


        return stringBuilder.toString();
    }
}
