package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

public class CreateNewReferenceArrayInstruction implements Instruction {
    private byte format;
    private byte indexByte1;
    private byte indexByte2;

    public CreateNewReferenceArrayInstruction(byte format, byte indexByte1, byte indexByte2) {
        this.format = format;
        this.indexByte1 = indexByte1;
        this.indexByte2 = indexByte2;
    }

    public byte getANewArray() {
        return format;
    }

    public void setANewArray(byte aNewArray) {
        this.format = aNewArray;
    }

    public byte getIndexByte1() {
        return indexByte1;
    }

    public void setIndexByte1(byte indexByte1) {
        this.indexByte1 = indexByte1;
    }

    public byte getIndexByte2() {
        return indexByte2;
    }

    public void setIndexByte2(byte indexByte2) {
        this.indexByte2 = indexByte2;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n            - anewarray instruction: ");

        stringBuilder.append(String.format("%02X", format));
        stringBuilder.append(String.format("%02X", indexByte1));
        stringBuilder.append(String.format("%02X", indexByte2));


        return stringBuilder.toString();
    }
    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        output.add(String.format("%02X", format));
        output.add(String.format("%02X", indexByte1));
        output.add(String.format("%02X", indexByte2));


        return output;
    }
}
