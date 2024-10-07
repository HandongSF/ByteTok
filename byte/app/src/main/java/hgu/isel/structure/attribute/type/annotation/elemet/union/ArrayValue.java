package hgu.isel.structure.attribute.type.annotation.elemet.union;

import hgu.isel.structure.attribute.type.annotation.ElementValue;
import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

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
}
