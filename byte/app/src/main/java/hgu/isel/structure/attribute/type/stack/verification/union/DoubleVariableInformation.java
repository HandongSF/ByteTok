package hgu.isel.structure.attribute.type.stack.verification.union;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class DoubleVariableInformation implements VerificationTypeInformation {
    private final byte tag = 3;

    public DoubleVariableInformation() {
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", tag));

        return stringBuilder.toString();
    }
}
