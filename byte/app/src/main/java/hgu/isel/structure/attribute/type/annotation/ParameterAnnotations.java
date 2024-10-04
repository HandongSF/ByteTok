package hgu.isel.structure.attribute.type.annotation;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;

public class ParameterAnnotations {
    private byte[] numberOfAnnotations; // u2
    private Annotation[] annotations; // numberOfAnnotations

    public byte[] getNumberOfAnnotations() {
        return numberOfAnnotations;
    }

    public void setNumberOfAnnotations(byte[] numberOfAnnotations) {
        this.numberOfAnnotations = numberOfAnnotations;
    }

    public Annotation[] getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotation[] annotations) {
        this.annotations = annotations;
    }

    public ParameterAnnotations(byte[] numberOfAnnotations, Annotation[] annotations) {
        this.numberOfAnnotations = numberOfAnnotations;
        this.annotations = annotations;
    }
}
