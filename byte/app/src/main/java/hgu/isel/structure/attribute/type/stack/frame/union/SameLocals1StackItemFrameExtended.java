package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

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
}
