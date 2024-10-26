/*
 * This source file was generated by the Gradle 'init' task
 */
package hgu.isel;

import hgu.isel.analyzer.ByteAnalyzer;
import hgu.isel.reader.ByteReader;
import hgu.isel.tokenizer.ByteStructure;
import hgu.isel.tokenizer.ByteTokenizer;

public class ByteTok {
    byte[] bytes;

    public static void main(String[] args) {
        ByteTok parser = new ByteTok();
        parser.run(args[0]);
    }

    public void run(String path) {
        ByteReader byteReader = new ByteReader(path);
        bytes = byteReader.readClassFile();

        ByteAnalyzer byteAnalyzer = new ByteAnalyzer(bytes);
        try {
            ByteStructure byteStructure = byteAnalyzer.analyze();
            System.out.println(byteAnalyzer.printResult());

            ByteTokenizer byteTokenizer = new ByteTokenizer(byteStructure);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
