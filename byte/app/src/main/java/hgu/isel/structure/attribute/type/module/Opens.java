package hgu.isel.structure.attribute.type.module;

import hgu.isel.structure.attribute.type.module.open.OpenIndex;

public class Opens {
    private byte[] opensIndex; // u2
    private byte[] opensFlags; // u2
    private byte[] opensToCount; // u2
    private OpenIndex[] opensToIndex; // opensToCount
}
