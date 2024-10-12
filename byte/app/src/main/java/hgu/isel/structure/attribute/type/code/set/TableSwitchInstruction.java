package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;
import hgu.isel.structure.attribute.type.code.set.jump.JumpOffset;

public class TableSwitchInstruction implements Instruction {
    private byte format;
    private byte[] paddingBytes;
    private byte[] defaultByte;
    private byte[] lowBytes;
    private byte[] highBytes;
    private JumpOffset[] jumpOffsets;

    public TableSwitchInstruction(byte format, byte[] paddingBytes, byte[] defaultByte, byte[] lowBytes, byte[] highBytes, JumpOffset[] jumpOffsets) {
        this.format = format;
        this.paddingBytes = paddingBytes;
        this.defaultByte = defaultByte;
        this.lowBytes = lowBytes;
        this.highBytes = highBytes;
        this.jumpOffsets = jumpOffsets;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte[] getPaddingBytes() {
        return paddingBytes;
    }

    public void setPaddingBytes(byte[] paddingBytes) {
        this.paddingBytes = paddingBytes;
    }

    public byte[] getDefaultByte() {
        return defaultByte;
    }

    public void setDefaultByte(byte[] defaultByte) {
        this.defaultByte = defaultByte;
    }

    public byte[] getLowBytes() {
        return lowBytes;
    }

    public void setLowBytes(byte[] lowBytes) {
        this.lowBytes = lowBytes;
    }

    public byte[] getHighBytes() {
        return highBytes;
    }

    public void setHighBytes(byte[] highBytes) {
        this.highBytes = highBytes;
    }

    public JumpOffset[] getJumpOffsets() {
        return jumpOffsets;
    }

    public void setJumpOffsets(JumpOffset[] jumpOffsets) {
        this.jumpOffsets = jumpOffsets;
    }
}
