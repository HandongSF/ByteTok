package hgu.isel.structure.attribute.type.annotation;

import hgu.isel.structure.attribute.type.path.TypePath;
import hgu.isel.structure.attribute.type.target.TargetInformation;

public class TypeAnnotation {
    private byte targetType;
    private TargetInformation targetInformation;
    private TypePath targetPath;
    private byte[] typeIndex; // u2
    private byte[] numberOfElementValuePairs; // u2
    private ElementValuePairs[] elementValuePairs; // numberOfElementValuePairs
}
