package hgu.isel.structure.attribute.type.module.uses;

public class UsesIndex {
    private byte[] usesIndex; // u2

    public byte[] getUsesIndex() {
        return usesIndex;
    }

    public void setUsesIndex(byte[] usesIndex) {
        this.usesIndex = usesIndex;
    }

    public UsesIndex(byte[] usesIndex) {
        this.usesIndex = usesIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : usesIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
