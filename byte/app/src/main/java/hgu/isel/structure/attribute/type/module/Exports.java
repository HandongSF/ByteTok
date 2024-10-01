package hgu.isel.structure.attribute.type.module;

import hgu.isel.structure.attribute.type.module.export.ExportIndex;

public class Exports {
    private byte[] exportsIndex; // u2
    private byte[] exportsFlags; // u2
    private byte[] exportsToCount; // u2
    private ExportIndex[] exportsToIndex; // numberOfExportsToCount
}
