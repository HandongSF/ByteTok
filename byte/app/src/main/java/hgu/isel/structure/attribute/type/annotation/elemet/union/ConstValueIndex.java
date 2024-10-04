package hgu.isel.structure.attribute.type.annotation.elemet.union;

import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

public class ConstValueIndex implements ElementUnion {
    private byte[] constValueIndex;

    public byte[] getConstValueIndex() {
        return constValueIndex;
    }

    public void setConstValueIndex(byte[] constValueIndex) {
        this.constValueIndex = constValueIndex;
    }

    public ConstValueIndex(byte[] constValueIndex) {
        this.constValueIndex = constValueIndex;
    }
}
