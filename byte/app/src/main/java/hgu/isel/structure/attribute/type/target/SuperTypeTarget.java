package hgu.isel.structure.attribute.type.target;


import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : superTpeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
