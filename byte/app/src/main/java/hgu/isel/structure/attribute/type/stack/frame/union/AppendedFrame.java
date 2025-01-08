package hgu.isel.structure.attribute.type.stack.frame.union;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;
import hgu.isel.structure.attribute.type.stack.frame.StackMapFrame;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", frameType));

        for(byte b : offsetDelta) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(VerificationTypeInformation v : locals) {
            stringBuilder.append(v.toString());
        }



        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Appended Frame Type]");
        stringBuilder.append(String.format("%02X", frameType));
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Appended Frame Offset Delta]");
        for(byte b : offsetDelta) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);


        for(VerificationTypeInformation c : locals) {
            output.addAll(c.tokenize());
        }

        return output;
    }
}
