package hgu.isel.structure.constant.type;


import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;
import hgu.isel.structure.constant.ConstantPoolInformation;

import java.util.ArrayList;
import java.util.List;

public class ClassInformation implements ConstantPoolInformation {
    private byte tag; // u1
    private byte[] nameIndex; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(byte[] nameIndex) {
        this.nameIndex = nameIndex;
    }

    public ClassInformation(byte tag, byte[] nameIndex) {
        this.tag = tag;
        this.nameIndex = nameIndex;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n    - ClassInformation: ");
        stringBuilder.append(String.format("%02X", tag));

        for(byte b : nameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }


    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Constant Pool Information Tag] ");
        stringBuilder.append(String.format("%02X", tag));

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        stringBuilder.append("[Constant Pool Information Name Index] ");
        for(byte b : nameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());


        return output;
    }
}
