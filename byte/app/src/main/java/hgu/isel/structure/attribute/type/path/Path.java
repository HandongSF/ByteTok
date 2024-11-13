package hgu.isel.structure.attribute.type.path;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private byte typePathKind;
    private byte typeArgumentIndex;

    public byte getTypePathKind() {
        return typePathKind;
    }

    public void setTypePathKind(byte typePathKind) {
        this.typePathKind = typePathKind;
    }

    public byte getTypeArgumentIndex() {
        return typeArgumentIndex;
    }

    public void setTypeArgumentIndex(byte typeArgumentIndex) {
        this.typeArgumentIndex = typeArgumentIndex;
    }

    public Path(byte typePathKind, byte typeArgumentIndex) {
        this.typePathKind = typePathKind;
        this.typeArgumentIndex = typeArgumentIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%02X", typePathKind));
        stringBuilder.append(String.format("%02X", typeArgumentIndex));

        return stringBuilder.toString();
    }


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        output.add("[Path Kind]");
        stringBuilder.append(String.format("%02X", typePathKind));

        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        output.add("[Path Argument Index]");
        stringBuilder.append(String.format("%02X", typeArgumentIndex));

        output.add(stringBuilder.toString());

        return output;
    }
}
