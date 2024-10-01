package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class FieldReferenceInformation implements ConstantPoolInformation {
    private byte tag; // u1
    private byte[] classIndex; // u2
    private byte[] nameAndTypeIndex; // u2
}
