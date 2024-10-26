package hgu.isel.tokenizer;

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

        for(byte b : byteStructure.getMagic()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : byteStructure.getMinorVersion()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : byteStructure.getMajorVersion()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : byteStructure.getConstantPoolCount()) {
            stringBuilder.append(String.format("%02X", b));
        }
        inputs.add(stringBuilder.toString());
        stringBuilder.setLength(0);












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
