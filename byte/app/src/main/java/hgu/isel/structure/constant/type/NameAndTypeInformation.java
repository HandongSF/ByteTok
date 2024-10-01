package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class NameAndTypeInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] nameIndex; // u2
    private byte[] descriptorIndex; // u2
}
