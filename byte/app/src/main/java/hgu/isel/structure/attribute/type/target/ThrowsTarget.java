package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class ThrowsTarget implements TargetInformation{
    private byte[] throwsTypeIndex; // u2

    public byte[] getThrowsTypeIndex() {
        return throwsTypeIndex;
    }

    public void setThrowsTypeIndex(byte[] throwsTypeIndex) {
        this.throwsTypeIndex = throwsTypeIndex;
    }

    public ThrowsTarget(byte[] throwsTypeIndex) {
        this.throwsTypeIndex = throwsTypeIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : throwsTypeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
