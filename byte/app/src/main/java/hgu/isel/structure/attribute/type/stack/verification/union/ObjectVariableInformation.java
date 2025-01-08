package hgu.isel.structure.attribute.type.stack.verification.union;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

public class ObjectVariableInformation implements VerificationTypeInformation {
    private final byte tag = 7;
    private byte[] constantPoolIndex; // u2

    public ObjectVariableInformation(byte[] constantPoolIndex) {
        this.constantPoolIndex = constantPoolIndex;
    }

    public byte getTag() {
        return tag;
    }

    public byte[] getConstantPoolIndex() {
        return constantPoolIndex;
    }

    public void setConstantPoolIndex(byte[] constantPoolIndex) {
        this.constantPoolIndex = constantPoolIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", tag));

        for(byte b : constantPoolIndex) {
            stringBuilder.append(String.format("%02X", b));
        }


        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Double Variable Verification]");
        stringBuilder.append(String.format("%02X", tag));
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Double Variable Verification Constant Pool Index]");
        for(byte b : constantPoolIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());

        return output;
    }
}
