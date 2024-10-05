package hgu.isel.structure.attribute.type.module;

import hgu.isel.structure.attribute.type.module.provide.ProvidesIndex;

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
}
