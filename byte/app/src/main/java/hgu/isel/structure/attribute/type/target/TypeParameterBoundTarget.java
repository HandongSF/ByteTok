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
public class TypeParameterBoundTarget implements TargetInformation {
    private byte typeParameterIndex;
    private byte boundIndex;

    public byte getTypeParameterIndex() {
        return typeParameterIndex;
    }

    public void setTypeParameterIndex(byte typeParameterIndex) {
        this.typeParameterIndex = typeParameterIndex;
    }

    public byte getBoundIndex() {
        return boundIndex;
    }

    public void setBoundIndex(byte boundIndex) {
        this.boundIndex = boundIndex;
    }

    public TypeParameterBoundTarget(byte typeParameterIndex, byte boundIndex) {
        this.typeParameterIndex = typeParameterIndex;
        this.boundIndex = boundIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", typeParameterIndex));
        stringBuilder.append(String.format("%02X", boundIndex));

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Type Parameter Bound Target Parameter Index]");
        stringBuilder.append(String.format("%02X", typeParameterIndex));
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Type Parameter Bound Target Bound Index]");
        stringBuilder.append(String.format("%02X", boundIndex));
        output.add(stringBuilder.toString());

        return output;
    }
}
