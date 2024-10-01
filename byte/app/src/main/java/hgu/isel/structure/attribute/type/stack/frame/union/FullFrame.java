package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class FullFrame implements StackMapFrame {
    private byte frameType; // 255
    private byte[] offsetDelta; // u2
    private byte[] numberOfLocals; // u2
    private VerificationTypeInformation[] locals; // numberOfLocals
    private byte[] numberOfStackItems; // u2
    private VerificationTypeInformation[] stack; // numberOfStackItems
}
