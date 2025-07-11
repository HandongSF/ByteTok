/*
 * This source file was generated by the Gradle 'init' task
 */
package hgu.isel;

import hgu.isel.analyzer.ByteAnalyzer;
import hgu.isel.reader.ByteReader;
import hgu.isel.tokenizer.ByteStructure;
import hgu.isel.tokenizer.ByteTokenizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ByteTok {
    private static HashSet<String> customAttributes = new HashSet<>();

    public static void main(String[] args) {
        ByteTok parser = new ByteTok();
        parser.run(args[0], args[1], args[2]);
    }

    public void run(String path, String option, String methodName) {

        if(option.equals("v")) {
            ByteReader byteReader = new ByteReader(path);
            List<String> filePaths = byteReader.readClassFilePaths();

            ByteTokenizer byteTokenizer = new ByteTokenizer();


            for(String s : filePaths) {
                byte[] bytes;
                bytes = byteReader.readClassFile(s);

                ByteAnalyzer byteAnalyzer = new ByteAnalyzer(bytes);
                try {
                    ByteStructure byteStructure = byteAnalyzer.analyze();
                    int hashSize = byteTokenizer.saveTokens(byteStructure);

		    

                    if(hashSize > 100000) { // up to maximum size
                        break;
                    }

                } catch (Exception e) {
                    try {
                        Path filePath = Paths.get(s);
                        Files.delete(filePath);
                        System.out.println("Deleted file: " + s);
                    } catch (IOException deleteException) {
                        System.err.println("Failed to delete file: " + s);

                    }
                }

            }
            byteTokenizer.createVocabulary();

        } else if(option.equals("t")) { // tokenization
            ByteReader byteReader = new ByteReader(path);

            byte[] bytes = byteReader.readClassFile();

            ByteAnalyzer byteAnalyzer = new ByteAnalyzer(bytes);
            ByteStructure byteStructure = null;
            try {
                byteStructure = byteAnalyzer.analyze();
                System.out.println(byteAnalyzer.printResult());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

//            ByteTokenizer byteTokenizer = new ByteTokenizer();

//            List<String> tokens = byteTokenizer.tokenize(byteStructure);

        } else if(option.equals("s")) { // delete kotlin / scala files
            ByteReader byteReader = new ByteReader(path);
            List<String> filePaths = byteReader.readClassFilePaths();

            byte[] bytes;

            for(String s : filePaths) {
                bytes = byteReader.readClassFile(s);

                ByteAnalyzer byteAnalyzer = new ByteAnalyzer(bytes);
                try {
                    byteAnalyzer.analyze();
                    System.out.println("Success!! : " + s);
                } catch (Exception e) {
                    try {
                        Path filePath = Paths.get(s);
                        Files.delete(filePath);
                        System.out.println("Deleted file: " + s);
                    } catch (IOException deleteException) {
                        System.err.println("Failed to delete file: " + s);

                    }
                }
            }
        } else if(option.equals("n")) { // generate new files as inputs of pre-trained model
            ByteReader byteReader = new ByteReader(path);
            List<String> filePaths = byteReader.readClassFilePaths();

            byte[] bytes;
            ByteTokenizer byteTokenizer = new ByteTokenizer();

            for(String s : filePaths) {
                bytes = byteReader.readClassFile(s);

                ByteAnalyzer byteAnalyzer = new ByteAnalyzer(bytes);
                try {
                    ByteStructure byteStructure = byteAnalyzer.analyze();
                    byteStructure.setFileName(s);

                    byteTokenizer.generateNewFilesWithConstantPool(byteStructure);
                    
                    System.out.println("Success: " + s);
                } catch (Exception e) {
                    System.out.println("Failed: " + s);
                    e.printStackTrace();
                }


            }
        } else if(option.equals("d")) { // delete / constant pool size > 480 then delete
            ByteReader byteReader = new ByteReader(path);
            List<String> filePaths = byteReader.readClassFilePaths();

            byte[] bytes;
            ByteTokenizer byteTokenizer = new ByteTokenizer();

            for(String s : filePaths) {
                bytes = byteReader.readClassFile(s);

                ByteAnalyzer byteAnalyzer = new ByteAnalyzer(bytes);
                try {
                    ByteStructure byteStructure = byteAnalyzer.analyze();
                    byteStructure.setFileName(s);

                    boolean isDelete = byteTokenizer.removeFiles(byteStructure);

                    if(isDelete) {
                        Path filePath = Paths.get(s);
                        Files.delete(filePath);

                        System.out.println("delete " + s);
                    }
                    System.out.println("not delete");


                } catch (Exception e) {

                    e.printStackTrace();
                }


            }
        } else if(option.equals("a")) { // find all customized attributes
            ByteReader byteReader = new ByteReader(path);
            List<String> filePaths = byteReader.readClassFilePaths();

            byte[] bytes;


            for(String s : filePaths) {
                bytes = byteReader.readClassFile(s);

                ByteAnalyzer byteAnalyzer = new ByteAnalyzer(bytes);
                try {
                    byteAnalyzer.analyze();
                } catch (Exception e) {
                    String attributeName = e.getMessage();
                    System.out.println("new attribute: " + attributeName);
                    customAttributes.add(attributeName);
                }
            }
        } else if(option.equals("m")) { // extract all methods from the input path
            ByteReader byteReader = new ByteReader(path);
            List<String> filePaths = byteReader.readClassFilePaths();

            byte[] bytes;
            ByteTokenizer byteTokenizer = new ByteTokenizer();

            for(String s : filePaths) {
                bytes = byteReader.readClassFile(s);

                ByteAnalyzer byteAnalyzer = new ByteAnalyzer(bytes);
                try {
                    ByteStructure byteStructure = byteAnalyzer.analyze();
                    byteStructure.setFileName(s);

                    byteTokenizer.generateNewFiles(byteStructure);

                    System.out.println("Success: " + s);
                } catch (Exception e) {
                    System.out.println("Failed: " + s);
                    e.printStackTrace();
                }
            }
        } else if(option.equals("p")) { // find specific method with input string
            ByteReader byteReader = new ByteReader(path);
            List<String> filePaths = byteReader.readClassFilePaths();

            byte[] bytes;
            ByteTokenizer byteTokenizer = new ByteTokenizer();

            for(String s : filePaths) {
                bytes = byteReader.readClassFile(s);

                ByteAnalyzer byteAnalyzer = new ByteAnalyzer(bytes);
                try {
                    ByteStructure byteStructure = byteAnalyzer.analyze();
                    byteStructure.setFileName(s);

                    byteTokenizer.findSpecificMethod(byteStructure, "");

                    System.out.println("Success: " + s);
                } catch (Exception e) {
                    System.out.println("Failed: " + s);
                    e.printStackTrace();
                }
            }
        }
    }

    public static HashSet<String> getCustomAttributes() {
        return customAttributes;
    }

    public static void setCustomAttributes(HashSet<String> customAttributes) {
        ByteTok.customAttributes = customAttributes;
    }
}
