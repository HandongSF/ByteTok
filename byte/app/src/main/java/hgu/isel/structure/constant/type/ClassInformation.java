package hgu.isel.structure.constant.type;


import hgu.isel.structure.constant.ConstantPoolInformation;

public class ClassInformation implements ConstantPoolInformation {
    private byte tag; // u1
    private byte[] nameIndex; // u2
}
