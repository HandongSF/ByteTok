package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

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
}
