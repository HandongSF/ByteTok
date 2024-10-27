package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;
import hgu.isel.structure.attribute.type.code.set.jump.JumpOffset;
import hgu.isel.structure.attribute.type.code.set.match.MatchOffsetPair;

import java.util.ArrayList;
import java.util.List;

public class LookUpSwitchInstruction implements Instruction {
    private byte format;
    private byte[] paddingByte; // 0x00으로 채워짐
    // format이 4바이트 경계에 위치하도록 해야함
    private byte[] defaultBytes;
    private byte[] nPairs;
    private MatchOffsetPair[] matchOffsetPairs; // nPairs의 수에 따라 offset pairs의 수가 결정됨

    public LookUpSwitchInstruction(byte format, byte[] paddingByte, byte[] defaultBytes, byte[] nPairs, MatchOffsetPair[] matchOffsetPairs) {
        this.format = format;
        this.paddingByte = paddingByte;
        this.defaultBytes = defaultBytes;
        this.nPairs = nPairs;
        this.matchOffsetPairs = matchOffsetPairs;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte[] getPaddingByte() {
        return paddingByte;
    }

    public void setPaddingByte(byte[] paddingByte) {
        this.paddingByte = paddingByte;
    }

    public byte[] getDefaultBytes() {
        return defaultBytes;
    }

    public void setDefaultBytes(byte[] defaultBytes) {
        this.defaultBytes = defaultBytes;
    }

    public byte[] getnPairs() {
        return nPairs;
    }

    public void setnPairs(byte[] nPairs) {
        this.nPairs = nPairs;
    }

    public MatchOffsetPair[] getMatchOffsetPairs() {
        return matchOffsetPairs;
    }

    public void setMatchOffsetPairs(MatchOffsetPair[] matchOffsetPairs) {
        this.matchOffsetPairs = matchOffsetPairs;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n             - lookupswitch instruction: ");

        stringBuilder.append(String.format("%02X", format));

        for(byte b : paddingByte) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : defaultBytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : nPairs) {
            stringBuilder.append(String.format("%02X", b));
        }


        for(MatchOffsetPair b : matchOffsetPairs) {
            stringBuilder.append(b.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        output.add(String.format("%02X", format));

        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : paddingByte) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : defaultBytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : nPairs) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(MatchOffsetPair m : matchOffsetPairs) {
            output.addAll(m.tokenize());
        }


        return output;
    }
}
