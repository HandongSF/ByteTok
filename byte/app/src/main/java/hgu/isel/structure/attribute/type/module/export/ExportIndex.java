package hgu.isel.structure.attribute.type.module.export;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class ExportIndex {
    private byte[] exportsToIndex; // u2

    public byte[] getExportsToIndex() {
        return exportsToIndex;
    }

    public void setExportsToIndex(byte[] exportsToIndex) {
        this.exportsToIndex = exportsToIndex;
    }

    public ExportIndex(byte[] exportsToIndex) {
        this.exportsToIndex = exportsToIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : exportsToIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Exports To Index]");
        for(byte b : exportsToIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
