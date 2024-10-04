package hgu.isel.structure.attribute.type.inner;

public class InnerClassInformation {
    private byte[] innerClassInformationIndex; // u2
    private byte[] outerClassInformationIndex; // u2
    private byte[] innerNameIndex; // u2
    private byte[] innerClassAccessFlags; // u2

    public byte[] getInnerClassInformationIndex() {
        return innerClassInformationIndex;
    }

    public void setInnerClassInformationIndex(byte[] innerClassInformationIndex) {
        this.innerClassInformationIndex = innerClassInformationIndex;
    }

    public byte[] getOuterClassInformationIndex() {
        return outerClassInformationIndex;
    }

    public void setOuterClassInformationIndex(byte[] outerClassInformationIndex) {
        this.outerClassInformationIndex = outerClassInformationIndex;
    }

    public byte[] getInnerNameIndex() {
        return innerNameIndex;
    }

    public void setInnerNameIndex(byte[] innerNameIndex) {
        this.innerNameIndex = innerNameIndex;
    }

    public byte[] getInnerClassAccessFlags() {
        return innerClassAccessFlags;
    }

    public void setInnerClassAccessFlags(byte[] innerClassAccessFlags) {
        this.innerClassAccessFlags = innerClassAccessFlags;
    }

    public InnerClassInformation(byte[] innerClassInformationIndex, byte[] outerClassInformationIndex, byte[] innerNameIndex, byte[] innerClassAccessFlags) {
        this.innerClassInformationIndex = innerClassInformationIndex;
        this.outerClassInformationIndex = outerClassInformationIndex;
        this.innerNameIndex = innerNameIndex;
        this.innerClassAccessFlags = innerClassAccessFlags;
    }
}
