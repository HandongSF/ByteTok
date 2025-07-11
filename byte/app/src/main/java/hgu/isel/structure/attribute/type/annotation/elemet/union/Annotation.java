package hgu.isel.structure.attribute.type.annotation.elemet.union;

import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;
import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class Annotation implements ElementUnion {
    private byte[] typeIndex; // u2
    private byte[] numberOfElementValuePairs; // u2
    private ElementValuePairs[] elementValuePairs; // numberOfElementValuePairs

    public byte[] getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(byte[] typeIndex) {
        this.typeIndex = typeIndex;
    }

    public byte[] getNumberOfElementValuePairs() {
        return numberOfElementValuePairs;
    }

    public void setNumberOfElementValuePairs(byte[] numberOfElementValuePairs) {
        this.numberOfElementValuePairs = numberOfElementValuePairs;
    }

    public ElementValuePairs[] getElementValuePairs() {
        return elementValuePairs;
    }

    public void setElementValuePairs(ElementValuePairs[] elementValuePairs) {
        this.elementValuePairs = elementValuePairs;
    }

    public Annotation(byte[] typeIndex, byte[] numberOfElementValuePairs, ElementValuePairs[] elementValuePairs) {
        this.typeIndex = typeIndex;
        this.numberOfElementValuePairs = numberOfElementValuePairs;
        this.elementValuePairs = elementValuePairs;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : typeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : numberOfElementValuePairs) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(ElementValuePairs e : elementValuePairs) {
            stringBuilder.append(e.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();


        // output.add("[Annotation Type Index]");

        for(byte b : typeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Annotation Element Value Pairs Number]");
        for(byte b : numberOfElementValuePairs) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());

        for(ElementValuePairs e : elementValuePairs) {
            for(String s : e.tokenize()) {
                // output.add("[Annotation Element Value Pairs]");
                stringBuilder.append(s);
                output.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }

        return output;
    }
}
