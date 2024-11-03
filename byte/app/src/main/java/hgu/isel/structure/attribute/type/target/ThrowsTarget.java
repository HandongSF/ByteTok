package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

public class ThrowsTarget implements TargetInformation{
    private byte[] throwsTypeIndex; // u2

    public byte[] getThrowsTypeIndex() {
        return throwsTypeIndex;
    }

    public void setThrowsTypeIndex(byte[] throwsTypeIndex) {
        this.throwsTypeIndex = throwsTypeIndex;
    }

    public ThrowsTarget(byte[] throwsTypeIndex) {
        this.throwsTypeIndex = throwsTypeIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : throwsTypeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[Throws Target Index] ");
        for(byte b : throwsTypeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
