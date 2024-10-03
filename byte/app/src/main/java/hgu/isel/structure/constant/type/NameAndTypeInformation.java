package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class NameAndTypeInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] nameIndex = new byte[2]; // u2
    private byte[] descriptorIndex = new byte[2]; // u2

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

    public byte[] getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(byte[] descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public NameAndTypeInformation(byte tag, byte[] nameIndex, byte[] descriptorIndex) {
        this.tag = tag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }
}
