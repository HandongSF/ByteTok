package hgu.isel;

import hgu.isel.analyzer.BytecodeAnalyzer;

import java.io.IOException;

public class ByteParser {

    public static void main(String[] args) throws IOException {
        BytecodeAnalyzer bytecodeAnalyzer = new BytecodeAnalyzer();
        bytecodeAnalyzer.analyzeClassFile("/Users/ehdrb01/Desktop/HGU/capstone/ByteParser/asm/app/src/main/java/hgu/isel/resource/GenericServlet.class");
    }
}
