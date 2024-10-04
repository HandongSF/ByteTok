package hgu.isel.structure.attribute.type.exception;

public class ExceptionIndexTable {
    private byte[] exceptionIndexTable; // u2

    public byte[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }

    public void setExceptionIndexTable(byte[] exceptionIndexTable) {
        this.exceptionIndexTable = exceptionIndexTable;
    }

    public ExceptionIndexTable(byte[] exceptionIndexTable) {
        this.exceptionIndexTable = exceptionIndexTable;
    }
}
