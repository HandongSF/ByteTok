package hgu.isel.structure.attribute.type.stack.verification.union;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

public class LongVariableInformation implements VerificationTypeInformation {
    private final byte tag = 4;

    public LongVariableInformation() {
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", tag));

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        output.add(String.format("%02X", tag));

        return output;
    }
}
