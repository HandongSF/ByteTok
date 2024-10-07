package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class TypeParameterTarget implements TargetInformation{
    private byte typeParameterIndex;

    public byte getTypeParameterIndex() {
        return typeParameterIndex;
    }

    public void setTypeParameterIndex(byte typeParameterIndex) {
        this.typeParameterIndex = typeParameterIndex;
    }

    public TypeParameterTarget(byte typeParameterIndex) {
        this.typeParameterIndex = typeParameterIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", typeParameterIndex));

        return stringBuilder.toString();
    }
}
