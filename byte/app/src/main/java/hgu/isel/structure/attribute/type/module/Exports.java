package hgu.isel.structure.attribute.type.module;

import hgu.isel.structure.attribute.type.module.export.ExportIndex;

public class Exports {
    private byte[] exportsIndex; // u2
    private byte[] exportsFlags; // u2
    private byte[] exportsToCount; // u2
    private ExportIndex[] exportsToIndex; // numberOfExportsToCount

    public byte[] getExportsIndex() {
        return exportsIndex;
    }

    public void setExportsIndex(byte[] exportsIndex) {
        this.exportsIndex = exportsIndex;
    }

    public byte[] getExportsFlags() {
        return exportsFlags;
    }

    public void setExportsFlags(byte[] exportsFlags) {
        this.exportsFlags = exportsFlags;
    }

    public byte[] getExportsToCount() {
        return exportsToCount;
    }

    public void setExportsToCount(byte[] exportsToCount) {
        this.exportsToCount = exportsToCount;
    }

    public ExportIndex[] getExportsToIndex() {
        return exportsToIndex;
    }

    public void setExportsToIndex(ExportIndex[] exportsToIndex) {
        this.exportsToIndex = exportsToIndex;
    }

    public Exports(byte[] exportsIndex, byte[] exportsFlags, byte[] exportsToCount, ExportIndex[] exportsToIndex) {
        this.exportsIndex = exportsIndex;
        this.exportsFlags = exportsFlags;
        this.exportsToCount = exportsToCount;
        this.exportsToIndex = exportsToIndex;
    }
}
