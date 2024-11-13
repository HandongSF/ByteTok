package hgu.isel.structure.attribute.type.annotation.elemet.union;

import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Class Information Index]");
        for(byte b : classInformationIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);


        return output;
    }
}
