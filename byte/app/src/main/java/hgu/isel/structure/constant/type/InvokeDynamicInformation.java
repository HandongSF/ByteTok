package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class InvokeDynamicInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] bootstrapMethodAttributeIndex; // u2
    private byte[] nameAndTypeIndex; // u2
}
