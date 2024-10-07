package hgu.isel.structure.attribute.type.line;

import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;

public class LineNumberTableInformation {
    private byte[] startPC; // u2
    private byte[] lineNumber; // u2

    public byte[] getStartPC() {
        return startPC;
    }

    public void setStartPC(byte[] startPC) {
        this.startPC = startPC;
    }

    public byte[] getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(byte[] lineNumber) {
        this.lineNumber = lineNumber;
    }

    public LineNumberTableInformation(byte[] startPC, byte[] lineNumber) {
        this.startPC = startPC;
        this.lineNumber = lineNumber;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : startPC) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : lineNumber) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
