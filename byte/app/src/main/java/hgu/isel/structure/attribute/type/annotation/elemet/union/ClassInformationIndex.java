package hgu.isel.structure.attribute.type.annotation.elemet.union;

import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

public class ClassInformationIndex implements ElementUnion {
    private byte[] classInformationIndex; // u2

    public byte[] getClassInformationIndex() {
        return classInformationIndex;
    }

    public void setClassInformationIndex(byte[] classInformationIndex) {
        this.classInformationIndex = classInformationIndex;
    }

    public ClassInformationIndex(byte[] classInformationIndex) {
        this.classInformationIndex = classInformationIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : classInformationIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
