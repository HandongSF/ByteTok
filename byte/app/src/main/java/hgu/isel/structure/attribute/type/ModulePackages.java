package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.type.packages.PackageIndex;

public class ModulePackages {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] packageCount; // u2
    private PackageIndex[] packageIndex; // packageCount

    public byte[] getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(byte[] attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public byte[] getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(byte[] attributeLength) {
        this.attributeLength = attributeLength;
    }

    public byte[] getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(byte[] packageCount) {
        this.packageCount = packageCount;
    }

    public PackageIndex[] getPackageIndex() {
        return packageIndex;
    }

    public void setPackageIndex(PackageIndex[] packageIndex) {
        this.packageIndex = packageIndex;
    }

    public ModulePackages(byte[] attributeNameIndex, byte[] attributeLength, byte[] packageCount, PackageIndex[] packageIndex) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.packageCount = packageCount;
        this.packageIndex = packageIndex;
    }
}
