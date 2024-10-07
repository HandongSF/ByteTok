package hgu.isel.structure.attribute.type.module.export;

public class ExportIndex {
    private byte[] exportsToIndex; // u2

    public byte[] getExportsToIndex() {
        return exportsToIndex;
    }

    public void setExportsToIndex(byte[] exportsToIndex) {
        this.exportsToIndex = exportsToIndex;
    }

    public ExportIndex(byte[] exportsToIndex) {
        this.exportsToIndex = exportsToIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : exportsToIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
