package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

public class StoreIntoReferenceLocalVariableInstruction implements Instruction {
    private byte format;
    private byte index;

    public StoreIntoReferenceLocalVariableInstruction(byte format, byte index) {
        this.format = format;
        this.index = index;
    }

    public byte getAStore() {
        return format;
    }

    public void setAStore(byte aStore) {
        this.format = aStore;
    }

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
    }
}
