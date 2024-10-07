package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class FormalParameterTarget implements TargetInformation{
    private byte formalParameterIndex;

    public byte getFormalParameterIndex() {
        return formalParameterIndex;
    }

    public void setFormalParameterIndex(byte formalParameterIndex) {
        this.formalParameterIndex = formalParameterIndex;
    }

    public FormalParameterTarget(byte formalParameterIndex) {
        this.formalParameterIndex = formalParameterIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", formalParameterIndex));

        return stringBuilder.toString();
    }
}
