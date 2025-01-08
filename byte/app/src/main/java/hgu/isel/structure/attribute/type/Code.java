package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;
import hgu.isel.structure.attribute.type.code.CodeAttributeAnalyzer;
import hgu.isel.structure.attribute.type.code.Instruction;
import hgu.isel.structure.attribute.type.exception.ExceptionTable;

import java.util.ArrayList;
import java.util.List;

public class Code implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4 563
    private byte[] maxStack; // u2
    private byte[] maxLocals; // u2
    private byte[] codeLength; // u4
    private ArrayList<Instruction> code; // codeLength
    private byte[] exceptionTableLength; // u2
    private ExceptionTable[] exceptionTable; // exceptionTableLength
    private byte[] attributesCount; // u2
    private AttributeInformation[] attributes; // attributesCount

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

    public byte[] getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(byte[] maxStack) {
        this.maxStack = maxStack;
    }

    public byte[] getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(byte[] maxLocals) {
        this.maxLocals = maxLocals;
    }

    public byte[] getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(byte[] codeLength) {
        this.codeLength = codeLength;
    }

    public ArrayList<Instruction> getCode() {
        return code;
    }

    public void setCode(ArrayList<Instruction> code) {
        this.code = code;
    }

    public byte[] getExceptionTableLength() {
        return exceptionTableLength;
    }

    public void setExceptionTableLength(byte[] exceptionTableLength) {
        this.exceptionTableLength = exceptionTableLength;
    }

    public ExceptionTable[] getExceptionTable() {
        return exceptionTable;
    }

    public void setExceptionTable(ExceptionTable[] exceptionTable) {
        this.exceptionTable = exceptionTable;
    }

    public byte[] getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(byte[] attributesCount) {
        this.attributesCount = attributesCount;
    }

    public AttributeInformation[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInformation[] attributes) {
        this.attributes = attributes;
    }

    public Code(byte[] attributeNameIndex, byte[] attributeLength, byte[] maxStack, byte[] maxLocals, byte[] codeLength, byte[] code, byte[] exceptionTableLength, ExceptionTable[] exceptionTable, byte[] attributesCount, AttributeInformation[] attributes, int totalOffset) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
        this.codeLength = codeLength;

        this.exceptionTableLength = exceptionTableLength;
        this.exceptionTable = exceptionTable;
        this.attributesCount = attributesCount;
        this.attributes = attributes;

        CodeAttributeAnalyzer codeAttributeAnalyzer = new CodeAttributeAnalyzer(code, totalOffset);

        codeAttributeAnalyzer.analyze();

        this.code = codeAttributeAnalyzer.getInstructions();
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n        - Code: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : maxStack) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : maxLocals) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : codeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(Instruction b : code) {
            stringBuilder.append(b.toString());
        }

        for(byte b : exceptionTableLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(ExceptionTable e : exceptionTable) {
            stringBuilder.append(e.toString());
        }

        for(byte b : attributesCount) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(AttributeInformation a : attributes) {
            stringBuilder.append(a.toString());
        }


        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Code Attribute Name Index]");
        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Code Attribute Length]");
        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Code Attribute Max Stack]");
        for(byte b : maxStack) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Code Attribute Max Locals]");
        for(byte b : maxLocals) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // output.add("[Code Attribute Code Length]");
        for(byte b : codeLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(Instruction i : code) {
            output.addAll(i.tokenize());
        }

        // output.add("[Code Attribute Exception Table Length]");
        for(byte b : exceptionTableLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(ExceptionTable i : exceptionTable) {
            output.addAll(i.tokenize());
        }

        // output.add("[Code Attribute Count]");
        for(byte b : attributesCount) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(AttributeInformation i : attributes) {
            output.addAll(i.tokenize());
        }


        return output;
    }
}
