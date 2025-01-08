package hgu.isel.tokenizer;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.constant.ConstantPoolInformation;
import hgu.isel.structure.field.FieldInformation;
import hgu.isel.structure.interfaces.Interfaces;
import hgu.isel.structure.method.MethodInformation;
import java.nio.file.StandardOpenOption;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ByteTokenizer {


    private HashSet<String> tokens = new HashSet<>(); // used to generate vocabulary


    public int saveTokens(ByteStructure byteStructure) {
        tokens.addAll(tokenize4vocab(byteStructure));

        return tokens.size();
    }

    public void createVocabulary() { // create vocabulary

        String filePath = "/data/donggyu/byteT5/Data/vocab.txt";
        List<String> list = new ArrayList<>(tokens);

        try {
            Files.write(Paths.get(filePath), list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFiles(String filePath, List<String> constantPool, List<String> method) {
        try {
            Files.write(Paths.get(filePath), constantPool, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.write(Paths.get(filePath), method, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateNewFiles(ByteStructure byteStructure) {
        List<String> constantPools = new ArrayList<>();
        List<String> methods = new ArrayList<>();

        String outputDirectory = "/data2/donggyu/input2/";
        File file = new File(byteStructure.getFileName());
        String fileName = file.getName();
        String fileNameWithoutExtension = fileName.replaceFirst("\\.class&", "");

        String outputFile = outputDirectory + fileNameWithoutExtension;

        for(int i = 0; i < byteStructure.getConstantPoolInformation().length; i++) {
            if(byteStructure.getConstantPoolInformation()[i] != null) {
                constantPools.addAll(byteStructure.getConstantPoolInformation()[i].tokenize(i + 1));
            }
        }

        for(int i = 0; i < byteStructure.getMethodInformation().length; i++) {
            methods.addAll(byteStructure.getMethodInformation()[i].tokenize());
            String inputFileName = outputFile + "_" + i + ".txt";

            writeFiles(inputFileName, constantPools, methods);
            methods.clear();
        }
    }

    public List<String> tokenize(ByteStructure byteStructure) { // translate input to tokenized one
        List<String> inputs = new ArrayList<>();
        List<String> methods = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        // // tokenize magic number
        // inputs.add("[Magic Number]");
        // for(byte b : byteStructure.getMagic()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // // tokenize minor version
        // inputs.add("[Minor Version]");
        // for(byte b : byteStructure.getMinorVersion()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // // tokenize major version
        // inputs.add("[Major Version]");
        // for(byte b : byteStructure.getMajorVersion()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // // tokenize constant pool count
        // inputs.add("[CP Count]");
        // for(byte b : byteStructure.getConstantPoolCount()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // tokenize constant pool
        for(int i = 0; i < byteStructure.getConstantPoolInformation().length; i++) {
            if(byteStructure.getConstantPoolInformation()[i] != null) {
                inputs.addAll(byteStructure.getConstantPoolInformation()[i].tokenize(i + 1));
            }
        }

        // // tokenize access flag
        // inputs.add("[Class Access Flag]");
        // for(byte b : byteStructure.getAccessFlag()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // // tokenize this class
        // inputs.add("[This Class]");
        // for(byte b : byteStructure.getThisClass()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // // tokenize super class
        // inputs.add("[Super Class]");
        // for(byte b : byteStructure.getSuperClass()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // // tokenize interface count
        // inputs.add("[Interface Count]");
        // for(byte b : byteStructure.getInterfacesCount()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // // tokenize interface
        // for(Interfaces i : byteStructure.getInterfaces()) {
        //     inputs.addAll(i.tokenize());
        // }

        // // tokenize fields count
        // inputs.add("[Fields Count]");
        // for(byte b : byteStructure.getFieldsCount()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // // tokenize fields
        // for(FieldInformation f : byteStructure.getFieldInformation()) {
        //     inputs.addAll(f.tokenize());
        // }

        // tokenize methods count
        // inputs.add("[Methods Count]");
        // for(byte b : byteStructure.getMethodsCount()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // tokenize methods
        // for(int i = 0; i < byteStructure.getMethodInformation()) {
        //     methods.addAll(byteStructure.getMethodInformation[i].tokenize());
        //     String fileName = byteStructure.getFileName() + "_" + i;

        //     writeFiles(fileName, inputs, methods);
        //     methods.clear();
        // }

        for(MethodInformation m : byteStructure.getMethodInformation()) {
            methods.addAll(m.tokenize());

            for(String s : inputs) {
                System.out.println(s);
            }
            for(String s : methods) {
                System.out.println(s);
            }

            System.out.println("[marker]");
            methods.clear();
        }
        

        // // tokenize attributes count
        // inputs.add("[Class Attributes Count]");
        // for(byte b : byteStructure.getAttributesCount()) {
        //     stringBuilder.append(String.format("%02X", b));
        // }
        // inputs.add(stringBuilder.toString());
        // stringBuilder.setLength(0);

        // // tokenize Attributes
        // for(AttributeInformation a : byteStructure.getAttributeInformation()) {
        //     inputs.addAll(a.tokenize());
        // }

        return inputs;
    }

    public List<String> tokenize4vocab(ByteStructure byteStructure) {

        List<String> inputs = new ArrayList<>();
        List<String> methods = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < byteStructure.getConstantPoolInformation().length; i++) {
            if(byteStructure.getConstantPoolInformation()[i] != null) {
                inputs.addAll(byteStructure.getConstantPoolInformation()[i].tokenize(i + 1));
            }
        }

        for(MethodInformation m : byteStructure.getMethodInformation()) {
            inputs.addAll(m.tokenize());
        }

        return inputs;

    }










    public ByteTokenizer() {
    }

    public HashSet<String> getTokens() {
        return tokens;
    }


    public void setTokens(HashSet<String> tokens) {
        this.tokens = tokens;
    }




}
