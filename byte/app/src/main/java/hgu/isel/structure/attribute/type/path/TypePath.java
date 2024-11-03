package hgu.isel.structure.attribute.type.path;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;

import java.util.ArrayList;
import java.util.List;

public class TypePath {
    private byte pathLength;
    private Path[] path; // pathLength

    public byte getPathLength() {
        return pathLength;
    }

    public void setPathLength(byte pathLength) {
        this.pathLength = pathLength;
    }

    public Path[] getPath() {
        return path;
    }

    public void setPath(Path[] path) {
        this.path = path;
    }

    public TypePath(byte pathLength, Path[] path) {
        this.pathLength = pathLength;
        this.path = path;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", pathLength));

        for(Path p : path) {
            stringBuilder.append(p.toString());
        }

        return stringBuilder.toString();
    }


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[Type Path Length] ");
        stringBuilder.append(String.format("%02X", pathLength));
        output.add(stringBuilder.toString());


        for(Path c : path) {
            output.addAll(c.tokenize());
        }

        return output;
    }
}
