package hgu.isel.tokenizer;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.constant.ConstantPoolInformation;
import hgu.isel.structure.field.FieldInformation;
import hgu.isel.structure.interfaces.Interfaces;
import hgu.isel.structure.method.MethodInformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ByteTokenizer {
    private ByteStructure byteStructure;
    private HashSet<String> tokens = new HashSet<>(); // used to generate vocabulary




    public void createVocabulary() { // create vocabulary

    }

    public void tokenize() { // translate input to tokenized one
        List<String> inputs = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        // tokenize magic number
        for(byte b : byteStructure.getMagic()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize minor version
        for(byte b : byteStructure.getMinorVersion()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize major version
        for(byte b : byteStructure.getMajorVersion()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize constant pool count
        for(byte b : byteStructure.getConstantPoolCount()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize constant pool
        for(ConstantPoolInformation c : byteStructure.getConstantPoolInformation()) {
            if(c != null) {
                inputs.addAll(c.tokenize());
            }
        }

        // tokenize access flag
        for(byte b : byteStructure.getAccessFlag()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize this class
        for(byte b : byteStructure.getThisClass()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize super class
        for(byte b : byteStructure.getSuperClass()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize interface count
        for(byte b : byteStructure.getInterfacesCount()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize interface
        for(Interfaces i : byteStructure.getInterfaces()) {
            inputs.addAll(i.tokenize());
        }

        // tokenize fields count
        for(byte b : byteStructure.getFieldsCount()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize fields
        for(FieldInformation f : byteStructure.getFieldInformation()) {
            inputs.addAll(f.tokenize());
        }

        // tokenize methods count
        for(byte b : byteStructure.getMethodsCount()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize methods
        for(MethodInformation m : byteStructure.getMethodInformation()) {
            inputs.addAll(m.tokenize());
        }

        // tokenize attributes count
        for(byte b : byteStructure.getAttributesCount()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize Attributes
        for(AttributeInformation a : byteStructure.getAttributeInformation()) {
            inputs.addAll(a.tokenize());
        }

        for(String s : inputs) {
            System.out.println(s);
        }
    }






    public ByteTokenizer(ByteStructure byteStructure) {
        this.byteStructure = byteStructure;
    }

    public ByteStructure getByteStructure() {
        return byteStructure;
    }

    public HashSet<String> getTokens() {
        return tokens;
    }

    public void setTokens(HashSet<String> tokens) {
        this.tokens = tokens;
    }

    public void setByteStructure(ByteStructure byteStructure) {
        this.byteStructure = byteStructure;
    }


}
