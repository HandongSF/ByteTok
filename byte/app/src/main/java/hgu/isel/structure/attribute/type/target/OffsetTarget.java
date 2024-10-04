package hgu.isel.structure.attribute.type.target;

public class OffsetTarget implements TargetInformation{
    private byte[] offset; // u2

    public byte[] getOffset() {
        return offset;
    }

    public void setOffset(byte[] offset) {
        this.offset = offset;
    }

    public OffsetTarget(byte[] offset) {
        this.offset = offset;
    }
}
