package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class MethodHandleInformation implements ConstantPoolInformation {
    private byte tag;
    private byte referenceKind;
    private byte[] referenceIndex; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(byte referenceKind) {
        this.referenceKind = referenceKind;
    }

    public byte[] getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(byte[] referenceIndex) {
        this.referenceIndex = referenceIndex;
    }

    public MethodHandleInformation(byte tag, byte referenceKind, byte[] referenceIndex) {
        this.tag = tag;
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;
    }
}
