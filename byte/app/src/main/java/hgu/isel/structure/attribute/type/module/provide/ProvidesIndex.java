package hgu.isel.structure.attribute.type.module.provide;

import java.util.ArrayList;
import java.util.List;

public class ProvidesIndex {
    private byte[] providesIndex;

    public byte[] getProvidesIndex() {
        return providesIndex;
    }

    public void setProvidesIndex(byte[] providesIndex) {
        this.providesIndex = providesIndex;
    }

    public ProvidesIndex(byte[] providesIndex) {
        this.providesIndex = providesIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : providesIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Provides Information Index]");
        for(byte b : providesIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
