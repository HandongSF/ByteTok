package hgu.isel.structure.attribute.type.module.provide;

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
}
