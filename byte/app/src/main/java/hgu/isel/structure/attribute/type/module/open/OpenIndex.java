package hgu.isel.structure.attribute.type.module.open;

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
}
