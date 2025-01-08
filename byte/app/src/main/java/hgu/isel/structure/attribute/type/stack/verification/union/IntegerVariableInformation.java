package hgu.isel.structure.attribute.type.stack.verification.union;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

public class IntegerVariableInformation implements VerificationTypeInformation {
    private final byte tag = 1;

    public IntegerVariableInformation() {
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", tag));

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Integer Variable Verification]");
        stringBuilder.append(String.format("%02X", tag));
        output.add(stringBuilder.toString());

        return output;
    }
}
