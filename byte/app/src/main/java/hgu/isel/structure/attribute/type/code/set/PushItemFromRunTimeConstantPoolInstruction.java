package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

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
}
