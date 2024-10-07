package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class TypeArgumentTarget implements TargetInformation{
    private byte[] offset; // u2
    private byte typeArgumentIndex;

    public byte[] getOffset() {
        return offset;
    }

    public void setOffset(byte[] offset) {
        this.offset = offset;
    }

    public byte getTypeArgumentIndex() {
        return typeArgumentIndex;
    }

    public void setTypeArgumentIndex(byte typeArgumentIndex) {
        this.typeArgumentIndex = typeArgumentIndex;
    }

    public TypeArgumentTarget(byte[] offset, byte typeArgumentIndex) {
        this.offset = offset;
        this.typeArgumentIndex = typeArgumentIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();



        for(byte b : offset) {
            stringBuilder.append(String.format("%02X", b));
        }
        stringBuilder.append(String.format("%02X", typeArgumentIndex));

        return stringBuilder.toString();
    }
}
