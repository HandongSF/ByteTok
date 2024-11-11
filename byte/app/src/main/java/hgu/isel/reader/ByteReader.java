package hgu.isel.reader;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ByteReader {
    private final String inputPath;

    public ByteReader(String inputPath) {
        this.inputPath = inputPath;
    }

    public byte[] readClassFile() {
        try {
            return Files.readAllBytes(Paths.get(inputPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Map<String, byte[]> readClassFiles() {
        Path startPath = Paths.get(inputPath);
        Map<String, byte[]> fileDataMap = new HashMap<>();

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".class")) {
                        String fileName = file.toString(); // 파일 이름
                        byte[] fileBytes = Files.readAllBytes(file); // 파일 데이터
                        fileDataMap.put(fileName, fileBytes);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileDataMap;
    }
}
