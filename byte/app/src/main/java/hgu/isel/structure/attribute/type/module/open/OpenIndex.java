package hgu.isel.structure.attribute.type.module.open;

import java.util.ArrayList;
import java.util.List;

public class OpenIndex {
    private byte[] opensToIndex; // u2

    public byte[] getOpensToIndex() {
        return opensToIndex;
    }

    public void setOpensToIndex(byte[] opensToIndex) {
        this.opensToIndex = opensToIndex;
    }

    public OpenIndex(byte[] opensToIndex) {
        this.opensToIndex = opensToIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : opensToIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Opens To Index]");
        for(byte b : opensToIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
