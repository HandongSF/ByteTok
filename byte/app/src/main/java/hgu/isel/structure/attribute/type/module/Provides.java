package hgu.isel.structure.attribute.type.module;

import hgu.isel.structure.attribute.type.module.provide.ProvidesIndex;

import java.util.ArrayList;
import java.util.List;

public class Provides {
    private byte[] providesIndex; // u2
    private byte[] providesWithCount; // u2
    private ProvidesIndex[] providesWithIndex; // u2

    public byte[] getProvidesIndex() {
        return providesIndex;
    }

    public void setProvidesIndex(byte[] providesIndex) {
        this.providesIndex = providesIndex;
    }

    public byte[] getProvidesWithCount() {
        return providesWithCount;
    }

    public void setProvidesWithCount(byte[] providesWithCount) {
        this.providesWithCount = providesWithCount;
    }

    public ProvidesIndex[] getProvidesWithIndex() {
        return providesWithIndex;
    }

    public void setProvidesWithIndex(ProvidesIndex[] providesWithIndex) {
        this.providesWithIndex = providesWithIndex;
    }

    public Provides(byte[] providesIndex, byte[] providesWithCount, ProvidesIndex[] providesWithIndex) {
        this.providesIndex = providesIndex;
        this.providesWithCount = providesWithCount;
        this.providesWithIndex = providesWithIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : providesIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : providesWithCount) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(ProvidesIndex p : providesWithIndex) {
            stringBuilder.append(p.toString());
        }

        return stringBuilder.toString();
    }

    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Provides Index]");
        for(byte b : providesIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.add("[Provides With Count]");
        for(byte b : providesWithCount) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(ProvidesIndex p : providesWithIndex) {
            output.addAll(p.tokenize());
        }

        return output;
    }
}
