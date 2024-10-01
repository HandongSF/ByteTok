package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class UTF8Information implements ConstantPoolInformation {
    private byte tag;
    private byte[] length; // u2
    private byte[] bytes; // length
}
