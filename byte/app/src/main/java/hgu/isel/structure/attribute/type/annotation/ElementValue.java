package hgu.isel.structure.attribute.type.annotation;

public class ElementValue {
    private byte tag;
    private byte[] constValueIndex; // u2(union)
    private EnumConstValue enumConstValue; // union
    private byte[] classInformationIndex; // u2(union)
    private Annotation annotationValue; // union
    private ArrayValue arrayValue; // union
}
