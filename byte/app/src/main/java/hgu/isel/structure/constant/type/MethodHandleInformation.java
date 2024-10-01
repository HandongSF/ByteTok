package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class MethodHandleInformation implements ConstantPoolInformation {
    private byte tag;
    private byte referenceKind;
    private byte[] referenceIndex; // u2
}
