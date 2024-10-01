package hgu.isel.structure.attribute.type.annotation;

public class Annotation {
    private byte[] typeIndex; // u2
    private byte[] numberOfElementValuePairs; // u2
    private ElementValuePairs[] elementValuePairs; // numberOfElementValuePairs
}
