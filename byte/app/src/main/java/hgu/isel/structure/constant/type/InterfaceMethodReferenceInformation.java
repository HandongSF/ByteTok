package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class InterfaceMethodReferenceInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] classIndex; // u2
    private byte[] nameAndTypeIndex; // u2
}
