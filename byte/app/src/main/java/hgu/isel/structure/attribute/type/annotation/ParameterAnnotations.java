package hgu.isel.structure.attribute.type.annotation;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class ParameterAnnotations {
    private byte[] numberOfAnnotations; // u2
    private Annotation[] annotations; // numberOfAnnotations

    public byte[] getNumberOfAnnotations() {
        return numberOfAnnotations;
    }

    public void setNumberOfAnnotations(byte[] numberOfAnnotations) {
        this.numberOfAnnotations = numberOfAnnotations;
    }

    public Annotation[] getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotation[] annotations) {
        this.annotations = annotations;
    }

    public ParameterAnnotations(byte[] numberOfAnnotations, Annotation[] annotations) {
        this.numberOfAnnotations = numberOfAnnotations;
        this.annotations = annotations;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : numberOfAnnotations) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(Annotation b : annotations) {
            stringBuilder.append(b.toString());
        }

        return stringBuilder.toString();
    }


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Parameter Annotation Number]");
        for(byte b : numberOfAnnotations) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(Annotation c : annotations) {
            output.addAll(c.tokenize());
        }

        return output;
    }
}
