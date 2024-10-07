package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class OffsetTarget implements TargetInformation{
    private byte[] offset; // u2

    public byte[] getOffset() {
        return offset;
    }

    public void setOffset(byte[] offset) {
        this.offset = offset;
    }

    public OffsetTarget(byte[] offset) {
        this.offset = offset;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : offset) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
