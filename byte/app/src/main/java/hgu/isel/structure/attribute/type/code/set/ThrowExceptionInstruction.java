package hgu.isel.structure.attribute.type.code.set;

import hgu.isel.structure.attribute.type.code.Instruction;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class ThrowExceptionInstruction implements Instruction { // athrow
    private byte format;

    public ThrowExceptionInstruction(byte format) {
        this.format = format;
    }

    public byte getAThrow() {
        return format;
    }

    public void setAThrow(byte aThrow) {
        this.format = aThrow;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n              - athrow instruction: ");

        stringBuilder.append(String.format("%02X", format));



        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        // output.add("[Throw Exception Instruction]");
        stringBuilder.append(String.format("%02X", format));



        output.add(stringBuilder.toString());



        return output;
    }
}
