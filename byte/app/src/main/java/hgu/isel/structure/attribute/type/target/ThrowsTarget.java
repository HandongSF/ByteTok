package hgu.isel.structure.attribute.type.target;

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
}
