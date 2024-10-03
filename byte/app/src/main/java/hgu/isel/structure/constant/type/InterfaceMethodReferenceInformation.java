package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class InterfaceMethodReferenceInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] classIndex = new byte[2]; // u2
    private byte[] nameAndTypeIndex = new byte[2]; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(byte[] classIndex) {
        this.classIndex = classIndex;
    }

    public byte[] getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(byte[] nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public InterfaceMethodReferenceInformation(byte tag, byte[] classIndex, byte[] nameAndTypeIndex) {
        this.tag = tag;
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}
