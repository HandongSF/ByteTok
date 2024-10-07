package hgu.isel.structure.attribute.type.target;


import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class TypeParameterBoundTarget implements TargetInformation {
    private byte typeParameterIndex;
    private byte boundIndex;

    public byte getTypeParameterIndex() {
        return typeParameterIndex;
    }

    public void setTypeParameterIndex(byte typeParameterIndex) {
        this.typeParameterIndex = typeParameterIndex;
    }

    public byte getBoundIndex() {
        return boundIndex;
    }

    public void setBoundIndex(byte boundIndex) {
        this.boundIndex = boundIndex;
    }

    public TypeParameterBoundTarget(byte typeParameterIndex, byte boundIndex) {
        this.typeParameterIndex = typeParameterIndex;
        this.boundIndex = boundIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", typeParameterIndex));
        stringBuilder.append(String.format("%02X", boundIndex));

        return stringBuilder.toString();
    }
}
