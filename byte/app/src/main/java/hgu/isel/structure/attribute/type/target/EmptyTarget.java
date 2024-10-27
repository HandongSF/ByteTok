package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

import java.util.ArrayList;
import java.util.List;

public class EmptyTarget implements TargetInformation{
    public EmptyTarget() {
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.toString();
    }

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        return output;
    }
}
