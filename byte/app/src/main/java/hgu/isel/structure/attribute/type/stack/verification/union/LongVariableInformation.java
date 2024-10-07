package hgu.isel.structure.attribute.type.stack.verification.union;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class LongVariableInformation implements VerificationTypeInformation {
    private final byte tag = 4;

    public LongVariableInformation() {
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", tag));

        return stringBuilder.toString();
    }
}
