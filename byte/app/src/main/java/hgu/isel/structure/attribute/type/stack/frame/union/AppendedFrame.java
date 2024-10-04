package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class AppendedFrame implements StackMapFrame {
    private byte frameType; // 252 - 254
    private byte[] offsetDelta; // u2
    private VerificationTypeInformation[] locals; // frameType - 251

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

    public VerificationTypeInformation[] getLocals() {
        return locals;
    }

    public void setLocals(VerificationTypeInformation[] locals) {
        this.locals = locals;
    }

    public AppendedFrame(byte frameType, byte[] offsetDelta, VerificationTypeInformation[] locals) {
        this.frameType = frameType;
        this.offsetDelta = offsetDelta;
        this.locals = locals;
    }
}
