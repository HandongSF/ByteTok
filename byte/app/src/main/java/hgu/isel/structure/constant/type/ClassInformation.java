package hgu.isel.structure.constant.type;


import hgu.isel.structure.constant.ConstantPoolInformation;

public class ClassInformation implements ConstantPoolInformation {
    private byte tag; // u1
    private byte[] nameIndex; // u2

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

    public ClassInformation(byte tag, byte[] nameIndex) {
        this.tag = tag;
        this.nameIndex = nameIndex;
    }

    public String toString() {
        return "ClassInformation";
    }
}
