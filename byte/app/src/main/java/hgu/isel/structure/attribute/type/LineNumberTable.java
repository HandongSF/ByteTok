package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;
import hgu.isel.structure.attribute.type.line.LineNumberTableInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class LineNumberTable implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] lineNumberTableLength; // u2
    private LineNumberTableInformation[] lineNumberTable; // lineNumberTableLength

    public byte[] getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(byte[] attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public byte[] getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(byte[] attributeLength) {
        this.attributeLength = attributeLength;
    }

    public byte[] getLineNumberTableLength() {
        return lineNumberTableLength;
    }

    public void setLineNumberTableLength(byte[] lineNumberTableLength) {
        this.lineNumberTableLength = lineNumberTableLength;
    }

    public LineNumberTableInformation[] getLineNumberTable() {
        return lineNumberTable;
    }

    public void setLineNumberTable(LineNumberTableInformation[] lineNumberTable) {
        this.lineNumberTable = lineNumberTable;
    }

    public LineNumberTable(byte[] attributeNameIndex, byte[] attributeLength, byte[] lineNumberTableLength, LineNumberTableInformation[] lineNumberTable) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.lineNumberTableLength = lineNumberTableLength;
        this.lineNumberTable = lineNumberTable;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n        - LineNumberTable: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : lineNumberTableLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(LineNumberTableInformation l : lineNumberTable) {
            stringBuilder.append(l.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Line Number Table Attribute Name Index]");
        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Line Number Table Attribute Length]");
        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Line Number Table Attribute Table Length]");
        for(byte b : lineNumberTableLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(LineNumberTableInformation l : lineNumberTable) {
            output.addAll(l.tokenize());
        }



        return output;
    }
}
