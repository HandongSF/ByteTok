package hgu.isel.structure.attribute.type.exception;

public class ExceptionTable {
    private byte[] startPC; // u2
    private byte[] endPC; // u2
    private byte[] handlerPC; // u2
    private byte[] catchType; // u2
}
