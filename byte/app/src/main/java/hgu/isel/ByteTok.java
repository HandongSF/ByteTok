/*
 * This source file was generated by the Gradle 'init' task
 */
package hgu.isel;

import hgu.isel.analyzer.ByteAnalyzer;
import hgu.isel.reader.ByteReader;

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
        byteAnalyzer.analyze();
    }
}
