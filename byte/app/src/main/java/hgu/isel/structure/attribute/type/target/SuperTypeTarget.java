package hgu.isel.structure.attribute.type.target;


import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : superTpeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
