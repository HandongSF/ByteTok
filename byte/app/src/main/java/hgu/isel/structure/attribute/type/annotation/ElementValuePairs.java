package hgu.isel.structure.attribute.type.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class ElementValuePairs {
    private byte[] elementNameIndex; // u2
    private ElementValue value;

    public byte[] getElementNameIndex() {
        return elementNameIndex;
    }

    public void setElementNameIndex(byte[] elementNameIndex) {
        this.elementNameIndex = elementNameIndex;
    }

    public ElementValue getValue() {
        return value;
    }

    public void setValue(ElementValue value) {
        this.value = value;
    }

    public ElementValuePairs(byte[] elementNameIndex, ElementValue value) {
        this.elementNameIndex = elementNameIndex;
        this.value = value;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : elementNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append(value.toString());

        return stringBuilder.toString();
    }


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Element Value Pairs Index]");
        for(byte b : elementNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.addAll(value.tokenize());


        return output;
    }
}
