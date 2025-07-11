package hgu.isel.structure.attribute.type.module.uses;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class UsesIndex {
    private byte[] usesIndex; // u2

    public byte[] getUsesIndex() {
        return usesIndex;
    }

    public void setUsesIndex(byte[] usesIndex) {
        this.usesIndex = usesIndex;
    }

    public UsesIndex(byte[] usesIndex) {
        this.usesIndex = usesIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : usesIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Uses Index]");
        for(byte b : usesIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
