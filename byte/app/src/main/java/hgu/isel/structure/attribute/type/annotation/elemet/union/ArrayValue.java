package hgu.isel.structure.attribute.type.annotation.elemet.union;

import hgu.isel.structure.attribute.type.annotation.ElementValue;
import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

import java.util.ArrayList;
import java.util.List;

public class ArrayValue implements ElementUnion {
    private byte[] numValues; // u2
    private ElementValue[] values; // numValues;

    public byte[] getNumValues() {
        return numValues;
    }

    public void setNumValues(byte[] numValues) {
        this.numValues = numValues;
    }

    public ElementValue[] getValues() {
        return values;
    }

    public void setValues(ElementValue[] values) {
        this.values = values;
    }

    public ArrayValue(byte[] numValues, ElementValue[] values) {
        this.numValues = numValues;
        this.values = values;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : numValues) {
            stringBuilder.append(String.format("%02X", b));
        }

        for (ElementValue value : values) {
            stringBuilder.append(value.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Array Value Number]");
        for(byte b : numValues) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(ElementValue e : values) {
            for(String s : e.tokenize()){
                output.add("[Array Value]");
                stringBuilder.append(s);
                output.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }


        return output;
    }
}
