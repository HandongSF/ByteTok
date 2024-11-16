package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceInformation implements ConstantPoolInformation {
    private byte tag; // u1
    private byte[] classIndex; // u2
    private byte[] nameAndTypeIndex; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(byte[] classIndex) {
        this.classIndex = classIndex;
    }

    public byte[] getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(byte[] nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public MethodReferenceInformation(byte tag, byte[] classIndex, byte[] nameAndTypeIndex) {
        this.tag = tag;
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n    - MethodReferenceInformation: ");
        stringBuilder.append(String.format("%02X", tag));

        for(byte b : classIndex) {
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

        // output.add("[Constant Method Reference Tag]");
        stringBuilder.append(String.format("%02X", tag));
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Constant Method Reference Class Index]");
        // for(byte b : classIndex) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // output.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // output.add("[Constant Method Reference Name and Type]");
        // for(byte b : nameAndTypeIndex) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // output.add(stringBuilder.toString());


        return output;
    }
}
