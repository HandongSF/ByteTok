package hgu.isel.structure.attribute.type.packages;

import java.util.ArrayList;
import java.util.List;

/**
 * This class supports the structure of the JVM bytecodes.
 * By overriding the toString(), tokenize() methods, it can analyze / tokenize the bytecodes.
 * <p>
 * All getters and setters in this class are simple property accessors with no side effects.
 */
public class PackageIndex {
    private byte[] packageIndex; // u2

    public byte[] getPackageIndex() {
        return packageIndex;
    }

    public void setPackageIndex(byte[] packageIndex) {
        this.packageIndex = packageIndex;
    }

    public PackageIndex(byte[] packageIndex) {
        this.packageIndex = packageIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : packageIndex) {
            stringBuilder.append(String.format("%02X", b));
        }


        return stringBuilder.toString();
    }


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Package Index]");
        for(byte b : packageIndex) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        return output;
    }
}
