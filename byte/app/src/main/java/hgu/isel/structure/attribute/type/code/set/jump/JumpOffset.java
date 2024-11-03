package hgu.isel.structure.attribute.type.code.set.jump;

import java.util.ArrayList;
import java.util.List;

public class JumpOffset {
    private byte[] info;

    public JumpOffset(byte[] info) {
        this.info = info;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : info) {
            stringBuilder.append(String.format("%02X", b));
        }



        return stringBuilder.toString();
    }


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Jump Offset Information] ");

        for(byte b : info) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());


        return output;
    }
}
