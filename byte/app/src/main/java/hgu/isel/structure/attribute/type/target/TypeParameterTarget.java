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
public class TypeParameterTarget implements TargetInformation{
    private byte typeParameterIndex;

    public byte getTypeParameterIndex() {
        return typeParameterIndex;
    }

    public void setTypeParameterIndex(byte typeParameterIndex) {
        this.typeParameterIndex = typeParameterIndex;
    }

    public TypeParameterTarget(byte typeParameterIndex) {
        this.typeParameterIndex = typeParameterIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", typeParameterIndex));

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Type Parameter Target Parameter Index]");
        stringBuilder.append(String.format("%02X", typeParameterIndex));
        output.add(stringBuilder.toString());


        return output;
    }
}
