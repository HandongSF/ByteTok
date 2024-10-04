package hgu.isel.structure.attribute.type.target;

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
}
