package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class SameLocals1StackItemFrame implements StackMapFrame {
    private byte frameType; // 64 - 127
    private VerificationTypeInformation stack; // 1

    public byte getFrameType() {
        return frameType;
    }

    public void setFrameType(byte frameType) {
        this.frameType = frameType;
    }

    public VerificationTypeInformation getStack() {
        return stack;
    }

    public void setStack(VerificationTypeInformation stack) {
        this.stack = stack;
    }

    public SameLocals1StackItemFrame(byte frameType, VerificationTypeInformation stack) {
        this.frameType = frameType;
        this.stack = stack;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", frameType));
        stringBuilder.append(stack.toString());

        return stringBuilder.toString();
    }
}
