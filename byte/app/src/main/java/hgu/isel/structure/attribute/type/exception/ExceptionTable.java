package hgu.isel.structure.attribute.type.exception;

import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;

public class ExceptionTable {
    private byte[] startPC; // u2
    private byte[] endPC; // u2
    private byte[] handlerPC; // u2
    private byte[] catchType; // u2

    public byte[] getStartPC() {
        return startPC;
    }

    public void setStartPC(byte[] startPC) {
        this.startPC = startPC;
    }

    public byte[] getEndPC() {
        return endPC;
    }

    public void setEndPC(byte[] endPC) {
        this.endPC = endPC;
    }

    public byte[] getHandlerPC() {
        return handlerPC;
    }

    public void setHandlerPC(byte[] handlerPC) {
        this.handlerPC = handlerPC;
    }

    public byte[] getCatchType() {
        return catchType;
    }

    public void setCatchType(byte[] catchType) {
        this.catchType = catchType;
    }

    public ExceptionTable(byte[] startPC, byte[] endPC, byte[] handlerPC, byte[] catchType) {
        this.startPC = startPC;
        this.endPC = endPC;
        this.handlerPC = handlerPC;
        this.catchType = catchType;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : startPC) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : endPC) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : handlerPC) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b: catchType) {
            stringBuilder.append(String.format("%02X", b));
        }



        return stringBuilder.toString();
    }
}
