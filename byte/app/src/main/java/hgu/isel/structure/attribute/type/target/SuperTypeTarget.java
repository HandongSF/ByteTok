package hgu.isel.structure.attribute.type.target;


import java.util.ArrayList;
import java.util.List;

public class SuperTypeTarget implements TargetInformation {
    private byte[] superTypeIndex; // u2

    public byte[] getSuperTypeIndex() {
        return superTypeIndex;
    }

    public void setSuperTypeIndex(byte[] superTypeIndex) {
        this.superTypeIndex = superTypeIndex;
    }

    public SuperTypeTarget(byte[] superTypeIndex) {
        this.superTypeIndex = superTypeIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : superTypeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[Super Type] ");
        for(byte b : superTypeIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
