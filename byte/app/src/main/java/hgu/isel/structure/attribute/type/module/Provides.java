package hgu.isel.structure.attribute.type.module;

public class Provides {
    private byte[] providesIndex; // u2
    private byte[] providesWithCount; // u2
    private byte[] providesWithIndex; // u2

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

    public byte[] getProvidesWithIndex() {
        return providesWithIndex;
    }

    public void setProvidesWithIndex(byte[] providesWithIndex) {
        this.providesWithIndex = providesWithIndex;
    }

    public Provides(byte[] providesIndex, byte[] providesWithCount, byte[] providesWithIndex) {
        this.providesIndex = providesIndex;
        this.providesWithCount = providesWithCount;
        this.providesWithIndex = providesWithIndex;
    }
}
