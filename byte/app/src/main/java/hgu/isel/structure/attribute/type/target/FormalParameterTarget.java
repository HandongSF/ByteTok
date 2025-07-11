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
public class FormalParameterTarget implements TargetInformation{
    private byte formalParameterIndex;

    public byte getFormalParameterIndex() {
        return formalParameterIndex;
    }

    public void setFormalParameterIndex(byte formalParameterIndex) {
        this.formalParameterIndex = formalParameterIndex;
    }

    public FormalParameterTarget(byte formalParameterIndex) {
        this.formalParameterIndex = formalParameterIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", formalParameterIndex));

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Formal Parameter Target]");
        stringBuilder.append(String.format("%02X", formalParameterIndex));
        output.add(stringBuilder.toString());

        return output;
    }
}
