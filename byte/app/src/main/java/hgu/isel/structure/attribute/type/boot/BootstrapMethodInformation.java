package hgu.isel.structure.attribute.type.boot;

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
}
