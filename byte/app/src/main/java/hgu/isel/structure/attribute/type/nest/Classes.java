package hgu.isel.structure.attribute.type.nest;

import java.util.ArrayList;
import java.util.List;

public class Classes {
    private byte[] bytes; // u2

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Classes(byte[] bytes) {
        this.bytes = bytes;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : bytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Class Byte]");
        for(byte b : bytes) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
