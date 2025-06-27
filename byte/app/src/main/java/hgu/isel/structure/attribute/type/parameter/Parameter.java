package hgu.isel.structure.attribute.type.parameter;

import hgu.isel.structure.attribute.type.local.LocalVariableTypeTableInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class Parameter {
    private byte[] nameIndex; // u2
    private byte[] accessFlags; // u2

    public byte[] getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(byte[] nameIndex) {
        this.nameIndex = nameIndex;
    }

    public byte[] getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(byte[] accessFlags) {
        this.accessFlags = accessFlags;
    }

    public Parameter(byte[] nameIndex, byte[] accessFlags) {
        this.nameIndex = nameIndex;
        this.accessFlags = accessFlags;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : nameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : accessFlags) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Parameter Name Index]");
        for(byte b : nameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Parameter Access Flag]");
        for(byte b : accessFlags) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
