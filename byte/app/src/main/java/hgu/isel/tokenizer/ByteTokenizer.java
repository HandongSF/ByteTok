package hgu.isel.tokenizer;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.constant.ConstantPoolInformation;
import hgu.isel.structure.field.FieldInformation;
import hgu.isel.structure.interfaces.Interfaces;
import hgu.isel.structure.method.MethodInformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ByteTokenizer {

    private List<ByteStructure> vocabByte;
    private HashSet<String> tokens = new HashSet<>(); // used to generate vocabulary
    private final int maxSize = 100000;



    public void createVocabulary() { // create vocabulary
        for(ByteStructure b : vocabByte) {
            tokens.addAll(tokenize(b));
            if(tokens.size() > maxSize) {
                break;
            }
        }

        String filePath = "output.txt";
        List<String> list = new ArrayList<>(tokens);

        try {
            Files.write(Paths.get(filePath), list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> tokenize(ByteStructure byteStructure) { // translate input to tokenized one
        List<String> inputs = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        // tokenize magic number
        stringBuilder.append("[Magic Number] ");
        for(byte b : byteStructure.getMagic()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize minor version
        stringBuilder.append("[Minor Version] ");
        for(byte b : byteStructure.getMinorVersion()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize major version
        stringBuilder.append("[Major Version] ");
        for(byte b : byteStructure.getMajorVersion()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize constant pool count
        stringBuilder.append("[CP Count] ");
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
        stringBuilder.append("[Class Access Flag] ");
        for(byte b : byteStructure.getAccessFlag()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize this class
        stringBuilder.append("[This Class] ");
        for(byte b : byteStructure.getThisClass()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize super class
        stringBuilder.append("[Super Class] ");
        for(byte b : byteStructure.getSuperClass()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize interface count
        stringBuilder.append("[Interface Count] ");
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
        stringBuilder.append("[Fields Count] ");
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
        stringBuilder.append("[Methods Count] ");
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
        stringBuilder.append("[Class Attributes Count] ");
        for(byte b : byteStructure.getAttributesCount()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        // tokenize Attributes
        for(AttributeInformation a : byteStructure.getAttributeInformation()) {
            inputs.addAll(a.tokenize());
        }

        return inputs;
    }








    public ByteTokenizer(List<ByteStructure> vocabByte) {
        this.vocabByte = vocabByte;
    }

    public ByteTokenizer() {
    }

    public HashSet<String> getTokens() {
        return tokens;
    }

    public List<ByteStructure> getVocabByte() {
        return vocabByte;
    }

    public void setVocabByte(List<ByteStructure> vocabByte) {
        this.vocabByte = vocabByte;
    }

    public void setTokens(HashSet<String> tokens) {
        this.tokens = tokens;
    }




}
