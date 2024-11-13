package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

import java.util.ArrayList;
import java.util.List;

public class MethodTypeInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] descriptorIndex; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(byte[] descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public MethodTypeInformation(byte tag, byte[] descriptorIndex) {
        this.tag = tag;
        this.descriptorIndex = descriptorIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n    - MethodTypeInformation: ");
        stringBuilder.append(String.format("%02X", tag));

        for(byte b : descriptorIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Constant Method Type Tag]");
        stringBuilder.append(String.format("%02X", tag));
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.add("[Constant Method Type Descriptor]");
        for(byte b : descriptorIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());



        return output;
    }
}
