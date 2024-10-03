package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class PackageInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] nameIndex = new byte[2]; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(byte[] nameIndex) {
        this.nameIndex = nameIndex;
    }

    public PackageInformation(byte tag, byte[] nameIndex) {
        this.tag = tag;
        this.nameIndex = nameIndex;
    }
}
