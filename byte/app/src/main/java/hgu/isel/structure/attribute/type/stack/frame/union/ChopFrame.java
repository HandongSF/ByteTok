package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;

public class ChopFrame implements StackMapFrame {
    private byte frameType; // 248 - 250
    private byte[] offsetDelta; // u2
}
