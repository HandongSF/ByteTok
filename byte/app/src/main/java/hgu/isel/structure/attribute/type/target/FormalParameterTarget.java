package hgu.isel.structure.attribute.type.target;

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
}
