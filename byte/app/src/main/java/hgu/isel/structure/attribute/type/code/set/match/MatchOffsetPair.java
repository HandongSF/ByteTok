package hgu.isel.structure.attribute.type.code.set.match;

import hgu.isel.structure.attribute.type.code.set.jump.JumpOffset;

import java.util.ArrayList;
import java.util.List;

public class MatchOffsetPair {
    private byte[] match;
    private byte[] offset;

    public MatchOffsetPair(byte[] match, byte[] offset) {
        this.match = match;
        this.offset = offset;
    }

    public byte[] getMatch() {
        return match;
    }

    public void setMatch(byte[] match) {
        this.match = match;
    }

    public byte[] getOffset() {
        return offset;
    }

    public void setOffset(byte[] offset) {
        this.offset = offset;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : match) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : offset) {
            stringBuilder.append(String.format("%02X", b));
        }



        return stringBuilder.toString();
    }

    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : match) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : offset) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
