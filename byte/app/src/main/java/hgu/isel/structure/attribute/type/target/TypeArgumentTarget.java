package hgu.isel.structure.attribute.type.target;

public class TypeArgumentTarget implements TargetInformation{
    private byte[] offset; // u2
    private byte typeArgumentIndex;

    public byte[] getOffset() {
        return offset;
    }

    public void setOffset(byte[] offset) {
        this.offset = offset;
    }

    public byte getTypeArgumentIndex() {
        return typeArgumentIndex;
    }

    public void setTypeArgumentIndex(byte typeArgumentIndex) {
        this.typeArgumentIndex = typeArgumentIndex;
    }

    public TypeArgumentTarget(byte[] offset, byte typeArgumentIndex) {
        this.offset = offset;
        this.typeArgumentIndex = typeArgumentIndex;
    }
}
