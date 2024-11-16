package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

import java.util.ArrayList;
import java.util.List;

public class DynamicInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] bootstrapMethodAttributeIndex; // u2
    private byte[] nameAndTypeIndex; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getBootstrapMethodAttributeIndex() {
        return bootstrapMethodAttributeIndex;
    }

    public void setBootstrapMethodAttributeIndex(byte[] bootstrapMethodAttributeIndex) {
        this.bootstrapMethodAttributeIndex = bootstrapMethodAttributeIndex;
    }

    public byte[] getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(byte[] nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public DynamicInformation(byte tag, byte[] bootstrapMethodAttributeIndex, byte[] nameAndTypeIndex) {
        this.tag = tag;
        this.bootstrapMethodAttributeIndex = bootstrapMethodAttributeIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n    - DynamicInformation: ");
        stringBuilder.append(String.format("%02X", tag));

        for(byte b : bootstrapMethodAttributeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : nameAndTypeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize(int index) {
        List<String> output = new ArrayList<>();
        output.add(String.valueOf(index));

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Constant Dynamic Information]");
        stringBuilder.append(String.format("%02X", tag));
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Constant Dynamic Bootstrap Method Attribute]");
        // for(byte b : bootstrapMethodAttributeIndex) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // output.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // output.add("[Constant Dynamic Name and Type Index]");
        // for(byte b : nameAndTypeIndex) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // output.add(stringBuilder.toString());


        return output;
    }
}
