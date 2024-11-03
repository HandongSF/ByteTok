package hgu.isel.reader;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

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

    public List<byte[]> readClassFiles() {
        Path startPath = Paths.get(inputPath);
        List<byte[]> bytes = new ArrayList<>();

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".class")) {
                        bytes.add(Files.readAllBytes(file));

                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }
}
