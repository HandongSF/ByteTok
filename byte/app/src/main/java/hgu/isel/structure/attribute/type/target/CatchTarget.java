package hgu.isel.structure.attribute.type.target;

public class CatchTarget implements TargetInformation{
    private byte[] exceptionTableIndex; // u2

    public byte[] getExceptionTableIndex() {
        return exceptionTableIndex;
    }

    public void setExceptionTableIndex(byte[] exceptionTableIndex) {
        this.exceptionTableIndex = exceptionTableIndex;
    }

    public CatchTarget(byte[] exceptionTableIndex) {
        this.exceptionTableIndex = exceptionTableIndex;
    }
}
