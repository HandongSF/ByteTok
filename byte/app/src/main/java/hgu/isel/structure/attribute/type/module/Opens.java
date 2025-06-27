package hgu.isel.structure.attribute.type.module;

import hgu.isel.structure.attribute.type.module.open.OpenIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class Opens {
    private byte[] opensIndex; // u2
    private byte[] opensFlags; // u2
    private byte[] opensToCount; // u2
    private OpenIndex[] opensToIndex; // opensToCount

    public byte[] getOpensIndex() {
        return opensIndex;
    }

    public void setOpensIndex(byte[] opensIndex) {
        this.opensIndex = opensIndex;
    }

    public byte[] getOpensFlags() {
        return opensFlags;
    }

    public void setOpensFlags(byte[] opensFlags) {
        this.opensFlags = opensFlags;
    }

    public byte[] getOpensToCount() {
        return opensToCount;
    }

    public void setOpensToCount(byte[] opensToCount) {
        this.opensToCount = opensToCount;
    }

    public OpenIndex[] getOpensToIndex() {
        return opensToIndex;
    }

    public void setOpensToIndex(OpenIndex[] opensToIndex) {
        this.opensToIndex = opensToIndex;
    }

    public Opens(byte[] opensIndex, byte[] opensFlags, byte[] opensToCount, OpenIndex[] opensToIndex) {
        this.opensIndex = opensIndex;
        this.opensFlags = opensFlags;
        this.opensToCount = opensToCount;
        this.opensToIndex = opensToIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : opensIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : opensFlags) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : opensToCount) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(OpenIndex e : opensToIndex) {
            stringBuilder.append(e.toString());
        }

        return stringBuilder.toString();
    }

    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Opens Index]");
        for(byte b : opensIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Opens Flag]");
        for(byte b : opensFlags) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Opens To Count]");
        for(byte b : opensToCount) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(OpenIndex o : opensToIndex) {
            output.addAll(o.tokenize());
        }

        return output;
    }

}
