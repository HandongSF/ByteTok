package hgu.isel.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
}
