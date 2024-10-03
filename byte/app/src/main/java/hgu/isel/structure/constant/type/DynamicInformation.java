package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class DynamicInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] bootstrapMethodAttributeIndex; // u2
    private byte[] nameAndTypeIndex; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getBootstrapMethodAttributeIndex() {
        return bootstrapMethodAttributeIndex;
    }

    public void setBootstrapMethodAttributeIndex(byte[] bootstrapMethodAttributeIndex) {
        this.bootstrapMethodAttributeIndex = bootstrapMethodAttributeIndex;
    }

    public byte[] getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(byte[] nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public DynamicInformation(byte tag, byte[] bootstrapMethodAttributeIndex, byte[] nameAndTypeIndex) {
        this.tag = tag;
        this.bootstrapMethodAttributeIndex = bootstrapMethodAttributeIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}
