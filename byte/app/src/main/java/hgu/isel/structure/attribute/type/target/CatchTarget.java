package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

public class CatchTarget implements TargetInformation{
    private byte[] exceptionTableIndex; // u2

    public byte[] getExceptionTableIndex() {
        return exceptionTableIndex;
    }

    public void setExceptionTableIndex(byte[] exceptionTableIndex) {
        this.exceptionTableIndex = exceptionTableIndex;
    }

    public CatchTarget(byte[] exceptionTableIndex) {
        this.exceptionTableIndex = exceptionTableIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : exceptionTableIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Catch Target]");
        for(byte b : exceptionTableIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);



        return output;
    }
}
