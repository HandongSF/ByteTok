package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class TypeArgumentTarget implements TargetInformation{
    private byte[] offset; // u2
    private byte typeArgumentIndex;

    public byte[] getOffset() {
        return offset;
    }

    public void setOffset(byte[] offset) {
        this.offset = offset;
    }

    public byte getTypeArgumentIndex() {
        return typeArgumentIndex;
    }

    public void setTypeArgumentIndex(byte typeArgumentIndex) {
        this.typeArgumentIndex = typeArgumentIndex;
    }

    public TypeArgumentTarget(byte[] offset, byte typeArgumentIndex) {
        this.offset = offset;
        this.typeArgumentIndex = typeArgumentIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();



        for(byte b : offset) {
            stringBuilder.append(String.format("%02X", b));
        }
        stringBuilder.append(String.format("%02X", typeArgumentIndex));

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Type Argument Target Offset]");
        for(byte b : offset) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Type Argument Index]");
        stringBuilder.append(String.format("%02X", typeArgumentIndex));
        output.add(stringBuilder.toString());

        return output;
    }
}
