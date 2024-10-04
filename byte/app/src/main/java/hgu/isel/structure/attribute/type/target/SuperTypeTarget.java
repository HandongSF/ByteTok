package hgu.isel.structure.attribute.type.target;


public class SuperTypeTarget implements TargetInformation {
    private byte[] superTpeIndex; // u2

    public byte[] getSuperTpeIndex() {
        return superTpeIndex;
    }

    public void setSuperTpeIndex(byte[] superTpeIndex) {
        this.superTpeIndex = superTpeIndex;
    }

    public SuperTypeTarget(byte[] superTpeIndex) {
        this.superTpeIndex = superTpeIndex;
    }
}
