package hgu.isel.structure.attribute.type.annotation.elemet.union;

import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

public class EnumConstValue implements ElementUnion {
    private byte[] typeNameIndex; // u2
    private byte[] constNameIndex; // u2

    public byte[] getTypeNameIndex() {
        return typeNameIndex;
    }

    public void setTypeNameIndex(byte[] typeNameIndex) {
        this.typeNameIndex = typeNameIndex;
    }

    public byte[] getConstNameIndex() {
        return constNameIndex;
    }

    public void setConstNameIndex(byte[] constNameIndex) {
        this.constNameIndex = constNameIndex;
    }

    public EnumConstValue(byte[] typeNameIndex, byte[] constNameIndex) {
        this.typeNameIndex = typeNameIndex;
        this.constNameIndex = constNameIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : typeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : constNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
