package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class StringInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] stringIndex; // u2
}
