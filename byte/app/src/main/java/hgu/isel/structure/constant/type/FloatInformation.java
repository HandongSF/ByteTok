package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

import java.util.ArrayList;
import java.util.List;

public class FloatInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] bytes; // u4

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public FloatInformation(byte tag, byte[] bytes) {
        this.tag = tag;
        this.bytes = bytes;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n    - FloatInformation: ");
        stringBuilder.append(String.format("%02X", tag));

        for(byte b : bytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Constant Float Tag]");
        stringBuilder.append(String.format("%02X", tag));
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.add("[Constant Float Byte]");
        for(byte b : bytes) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());


        return output;
    }
}
