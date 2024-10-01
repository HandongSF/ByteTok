package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class DoubleInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] highBytes; // u4
    private byte[] lowBytes; // u4
}
