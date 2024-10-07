package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class CatchTarget implements TargetInformation{
    private byte[] exceptionTableIndex; // u2

    public byte[] getExceptionTableIndex() {
        return exceptionTableIndex;
    }

    public void setExceptionTableIndex(byte[] exceptionTableIndex) {
        this.exceptionTableIndex = exceptionTableIndex;
    }

    public CatchTarget(byte[] exceptionTableIndex) {
        this.exceptionTableIndex = exceptionTableIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : exceptionTableIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
