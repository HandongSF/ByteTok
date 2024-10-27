package hgu.isel.structure.attribute.type.annotation.elemet.union;

import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

import java.util.ArrayList;
import java.util.List;

public class ConstValueIndex implements ElementUnion {
    private byte[] constValueIndex;

    public byte[] getConstValueIndex() {
        return constValueIndex;
    }

    public void setConstValueIndex(byte[] constValueIndex) {
        this.constValueIndex = constValueIndex;
    }

    public ConstValueIndex(byte[] constValueIndex) {
        this.constValueIndex = constValueIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : constValueIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : constValueIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);


        return output;
    }
}
