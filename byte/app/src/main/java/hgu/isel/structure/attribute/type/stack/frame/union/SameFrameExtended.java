package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

public class SameFrameExtended implements StackMapFrame {
    private byte frameType; // 251
    private byte[] offsetDelta; // u2

    public byte getFrameType() {
        return frameType;
    }

    public void setFrameType(byte frameType) {
        this.frameType = frameType;
    }

    public byte[] getOffsetDelta() {
        return offsetDelta;
    }

    public void setOffsetDelta(byte[] offsetDelta) {
        this.offsetDelta = offsetDelta;
    }

    public SameFrameExtended(byte frameType, byte[] offsetDelta) {
        this.frameType = frameType;
        this.offsetDelta = offsetDelta;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", frameType));

        for(byte b : offsetDelta) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        output.add("[Same Frame Extended]");
        stringBuilder.append(String.format("%02X", frameType));
        output.add(stringBuilder.toString());

        stringBuilder.setLength(0);

        output.add("[Same Frame Extended Offset Delta]");
        for(byte b : offsetDelta) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);


        return output;
    }
}
