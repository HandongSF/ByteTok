package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class MethodHandleInformation implements ConstantPoolInformation {
    private byte tag;
    private byte referenceKind;
    private byte[] referenceIndex; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(byte referenceKind) {
        this.referenceKind = referenceKind;
    }

    public byte[] getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(byte[] referenceIndex) {
        this.referenceIndex = referenceIndex;
    }

    public MethodHandleInformation(byte tag, byte referenceKind, byte[] referenceIndex) {
        this.tag = tag;
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n    - MethodHandleInformation: ");
        stringBuilder.append(String.format("%02X", tag));
        stringBuilder.append(String.format("%02X", referenceKind));

        for(byte b : referenceIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
    @Override
    public List<String> tokenize(int index) {
        List<String> output = new ArrayList<>();
        // output.add(String.valueOf(index));

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Constant Method Handle Tag]");
        stringBuilder.append(String.format("%02X", tag));
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);



        // output.add("[Constant Method Handle Reference Kind]");
        // stringBuilder.append(String.format("%02X", tag));
        // output.add(stringBuilder.toString());
        // stringBuilder.setLength(0);


        // output.add("[Constant Method Handle Reference Index]");
        // for(byte b : referenceIndex) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // output.add(stringBuilder.toString());


        return output;
    }
}
