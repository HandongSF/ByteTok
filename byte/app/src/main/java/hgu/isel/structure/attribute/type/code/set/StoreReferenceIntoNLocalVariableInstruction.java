package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class StoreReferenceIntoNLocalVariableInstruction implements Instruction {
    private byte format;

    public StoreReferenceIntoNLocalVariableInstruction(byte format) {
        this.format = format;
    }

    public byte getAStoreN() {
        return format;
    }

    public void setAStoreN(byte aStoreN) {
        this.format = aStoreN;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n              - astore_n instruction: ");

        stringBuilder.append(String.format("%02X", format));



        return stringBuilder.toString();
    }
}
