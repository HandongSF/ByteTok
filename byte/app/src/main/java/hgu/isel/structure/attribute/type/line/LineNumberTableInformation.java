package hgu.isel.structure.attribute.type.line;

import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
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


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Line Number Table Information Start PC]");
        for(byte b : startPC) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Line Number Table Information Line Number]");
        for(byte b : lineNumber) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);


        return output;
    }
}
