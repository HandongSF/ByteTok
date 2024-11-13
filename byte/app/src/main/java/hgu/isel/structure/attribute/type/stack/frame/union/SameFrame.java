package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

public class SameFrame implements StackMapFrame {
    private byte frameType; // 0 - 63

    public byte getFrameType() {
        return frameType;
    }

    public void setFrameType(byte frameType) {
        this.frameType = frameType;
    }

    public SameFrame(byte frameType) {
        this.frameType = frameType;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", frameType));

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        output.add("[Same Frame]");
        stringBuilder.append(String.format("%02X", frameType));
        output.add(stringBuilder.toString());



        return output;
    }
}
