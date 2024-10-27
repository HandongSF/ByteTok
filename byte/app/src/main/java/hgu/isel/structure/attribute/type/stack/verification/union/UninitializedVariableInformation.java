package hgu.isel.structure.attribute.type.stack.verification.union;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

public class UninitializedVariableInformation implements VerificationTypeInformation {
    private final byte tag = 8;
    private byte[] offset; // u2

    public UninitializedVariableInformation(byte[] offset) {
        this.offset = offset;
    }

    public byte[] getOffset() {
        return offset;
    }

    public void setOffset(byte[] offset) {
        this.offset = offset;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", tag));

        for(byte b : offset) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        output.add(String.format("%02X", tag));

        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : offset) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());

        return output;
    }
}
