package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class AppendedFrame implements StackMapFrame {
    private byte frameType; // 252 - 254
    private byte[] offsetDelta; // u2
    private VerificationTypeInformation[] locals; // frameType - 251
}
