package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;
import hgu.isel.structure.attribute.type.code.set.jump.JumpOffset;
import hgu.isel.structure.attribute.type.code.set.match.MatchOffsetPair;

import java.util.ArrayList;
import java.util.List;

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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n             - tableswitch instruction: ");

        stringBuilder.append(String.format("%02X", format));

        for(byte b : paddingBytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : defaultByte) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : lowBytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : highBytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(JumpOffset b : jumpOffsets) {
            stringBuilder.append(b.toString());
        }



        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Table Switch Instruction] ");
        stringBuilder.append(String.format("%02X", format));
        for(byte b : paddingBytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        stringBuilder.append("[Table Switch Default Byte] ");
        for(byte b : defaultByte) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        stringBuilder.append("[Table Switch Low Byte] ");
        for(byte b : lowBytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        stringBuilder.append("[Table Switch High Byte] ");
        for(byte b : highBytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(JumpOffset m : jumpOffsets) {
            output.addAll(m.tokenize());
        }


        return output;
    }
}
