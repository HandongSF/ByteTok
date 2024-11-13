package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

public class SameLocals1StackItemFrameExtended implements StackMapFrame {
    private byte frameType; // 247
    private byte[] offsetDelta; // u2
    private VerificationTypeInformation stack; // 1

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

    public VerificationTypeInformation getStack() {
        return stack;
    }

    public void setStack(VerificationTypeInformation stack) {
        this.stack = stack;
    }

    public SameLocals1StackItemFrameExtended(byte frameType, byte[] offsetDelta, VerificationTypeInformation stack) {
        this.frameType = frameType;
        this.offsetDelta = offsetDelta;
        this.stack = stack;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", frameType));

        for(byte b : offsetDelta) {
            stringBuilder.append(String.format("%02X", b));
        }

        stringBuilder.append(stack.toString());


        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Same Locals 1 Stack Item Frame Extended]");
        stringBuilder.append(String.format("%02X", frameType));
        output.add(stringBuilder.toString());


        stringBuilder.setLength(0);
        output.add("[Same Locals 1 Stack Item Frame Extended Offset Delta]");
        for(byte b : offsetDelta) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.addAll(stack.tokenize());


        return output;
    }
}
