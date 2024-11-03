/*
 * This source file was generated by the Gradle 'init' task
 */
package hgu.isel;

import hgu.isel.analyzer.ByteAnalyzer;
import hgu.isel.reader.ByteReader;
import hgu.isel.tokenizer.ByteStructure;
import hgu.isel.tokenizer.ByteTokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteTok {

    public static void main(String[] args) {
        ByteTok parser = new ByteTok();
        parser.run(args[0], args[1]);
    }

    public void run(String path, String option) {

        if(option.equals("v")) {
            ByteReader byteReader = new ByteReader(path);
            List<byte[]> byteList = byteReader.readClassFiles();
            List<ByteStructure> byteStructures = new ArrayList<>();

            for(byte[] b : byteList) {
                ByteAnalyzer byteAnalyzer = new ByteAnalyzer(b);
                try {
                    byteStructures.add(byteAnalyzer.analyze());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            ByteTokenizer byteTokenizer = new ByteTokenizer(byteStructures);
            byteTokenizer.createVocabulary();
        } else if(option.equals("t")) {
            ByteReader byteReader = new ByteReader(path);

            byte[] bytes = byteReader.readClassFile();
            ByteAnalyzer byteAnalyzer = new ByteAnalyzer(bytes);
            ByteStructure byteStructure = null;
            try {
                byteStructure = byteAnalyzer.analyze();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            ByteTokenizer byteTokenizer = new ByteTokenizer();

            List<String> tokens = byteTokenizer.tokenize(byteStructure);

        }
    }
}
