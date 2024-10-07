package hgu.isel.structure.attribute.type.exception;

import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;

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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : exceptionIndexTable) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
