package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.boot.BootstrapMethodInformation;
import hgu.isel.structure.attribute.type.exception.ExceptionIndexTable;

import java.util.ArrayList;
import java.util.List;

public class Exceptions implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] numberOfExceptions; // u2
    private ExceptionIndexTable[] exceptionIndexTable; // numberOfExceptions

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

    public byte[] getNumberOfExceptions() {
        return numberOfExceptions;
    }

    public void setNumberOfExceptions(byte[] numberOfExceptions) {
        this.numberOfExceptions = numberOfExceptions;
    }

    public ExceptionIndexTable[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }

    public void setExceptionIndexTable(ExceptionIndexTable[] exceptionIndexTable) {
        this.exceptionIndexTable = exceptionIndexTable;
    }

    public Exceptions(byte[] attributeNameIndex, byte[] attributeLength, byte[] numberOfExceptions, ExceptionIndexTable[] exceptionIndexTable) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.numberOfExceptions = numberOfExceptions;
        this.exceptionIndexTable = exceptionIndexTable;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n        - Exceptions: ");

        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : numberOfExceptions) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(ExceptionIndexTable e : exceptionIndexTable) {
            stringBuilder.append(e.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Exceptions Attribute Name Index]");
        for(byte b : attributeNameIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.add("[Exceptions Attribute Length]");
        for(byte b : attributeLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.add("[Exceptions Attribute Exception Number]");
        for(byte b : numberOfExceptions) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(ExceptionIndexTable e : exceptionIndexTable) {
            for(String s : e.tokenize()) {
                output.add("[Exceptions Attribute Exception Index Table]");
                stringBuilder.append(s);
                output.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }

        }


        return output;
    }

}
