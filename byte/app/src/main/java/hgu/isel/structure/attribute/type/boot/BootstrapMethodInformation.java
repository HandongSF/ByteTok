package hgu.isel.structure.attribute.type.boot;

import hgu.isel.structure.attribute.type.annotation.ElementValuePairs;

import java.util.ArrayList;
import java.util.List;

public class BootstrapMethodInformation {
    private byte[] bootstrapMethodReference; // u2
    private byte[] numberOfBootstrapArguments; // u2
    private BootstrapArgument[] bootstrapArguments; // numberOfBootstrapArguments

    public byte[] getBootstrapMethodReference() {
        return bootstrapMethodReference;
    }

    public void setBootstrapMethodReference(byte[] bootstrapMethodReference) {
        this.bootstrapMethodReference = bootstrapMethodReference;
    }

    public byte[] getNumberOfBootstrapArguments() {
        return numberOfBootstrapArguments;
    }

    public void setNumberOfBootstrapArguments(byte[] numberOfBootstrapArguments) {
        this.numberOfBootstrapArguments = numberOfBootstrapArguments;
    }

    public BootstrapArgument[] getBootstrapArguments() {
        return bootstrapArguments;
    }

    public void setBootstrapArguments(BootstrapArgument[] bootstrapArguments) {
        this.bootstrapArguments = bootstrapArguments;
    }

    public BootstrapMethodInformation(byte[] bootstrapMethodReference, byte[] numberOfBootstrapArguments, BootstrapArgument[] bootstrapArguments) {
        this.bootstrapMethodReference = bootstrapMethodReference;
        this.numberOfBootstrapArguments = numberOfBootstrapArguments;
        this.bootstrapArguments = bootstrapArguments;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();


        for(byte b : bootstrapMethodReference) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(byte b : numberOfBootstrapArguments) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(BootstrapArgument e : bootstrapArguments) {
            stringBuilder.append(e.toString());
        }

        return stringBuilder.toString();
    }


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : bootstrapMethodReference) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(byte b : numberOfBootstrapArguments) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());

        for(BootstrapArgument b : bootstrapArguments) {
            output.addAll(b.tokenize());
        }


        return output;
    }
}
