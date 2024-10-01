package hgu.isel.structure.attribute.type.boot;

public class BootstrapMethodInformation {
    private byte[] bootstrapMethodReference; // u2
    private byte[] numberOfBootstrapArguments; // u2
    private BootstrapArgument[] bootstrapArguments; // numberOfBootstrapArguments
}
