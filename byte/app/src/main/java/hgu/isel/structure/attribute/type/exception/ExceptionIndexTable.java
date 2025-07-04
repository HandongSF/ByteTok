package hgu.isel.structure.attribute.type.exception;

import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;

import java.util.ArrayList;
import java.util.List;
/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
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


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Exception Index Table]");
        for(byte b : exceptionIndexTable) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);


        return output;
    }
}
