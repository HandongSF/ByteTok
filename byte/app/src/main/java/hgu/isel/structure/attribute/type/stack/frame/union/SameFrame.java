package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;

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
}
