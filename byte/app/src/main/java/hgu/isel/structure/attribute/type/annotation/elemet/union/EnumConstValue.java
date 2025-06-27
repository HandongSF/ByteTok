package hgu.isel.structure.attribute.type.annotation.elemet.union;

import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class EnumConstValue implements ElementUnion {
    private byte[] typeNameIndex; // u2
    private byte[] constNameIndex; // u2

    public byte[] getTypeNameIndex() {
        return typeNameIndex;
    }

    public void setTypeNameIndex(byte[] typeNameIndex) {
        this.typeNameIndex = typeNameIndex;
    }

    public byte[] getConstNameIndex() {
        return constNameIndex;
    }

    public void setConstNameIndex(byte[] constNameIndex) {
        this.constNameIndex = constNameIndex;
    }

    public EnumConstValue(byte[] typeNameIndex, byte[] constNameIndex) {
        this.typeNameIndex = typeNameIndex;
        this.constNameIndex = constNameIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : typeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : constNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Enum Const Value Type and Name Index]");
        for(byte b : typeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Enum Const Value Const Name Index]");
        for(byte b : constNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());


        return output;
    }
}
