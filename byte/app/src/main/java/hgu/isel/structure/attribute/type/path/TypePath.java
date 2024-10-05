package hgu.isel.structure.attribute.type.path;

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
}
