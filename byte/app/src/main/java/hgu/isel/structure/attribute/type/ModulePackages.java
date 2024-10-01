package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.type.packages.PackageIndex;

public class ModulePackages {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] packageCount; // u2
    private PackageIndex[] packageIndex; // packageCount
}
