package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class LongInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] highBytes; // u4
    private byte[] lowBytes; // u4
}
