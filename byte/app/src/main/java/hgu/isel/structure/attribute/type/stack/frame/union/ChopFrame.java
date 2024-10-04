package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;

public class ChopFrame implements StackMapFrame {
    private byte frameType; // 248 - 250
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

    public ChopFrame(byte frameType, byte[] offsetDelta) {
        this.frameType = frameType;
        this.offsetDelta = offsetDelta;
    }
}
