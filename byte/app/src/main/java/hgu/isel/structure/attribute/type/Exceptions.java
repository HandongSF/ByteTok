package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.exception.ExceptionIndexTable;

public class Exceptions implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] numberOfExceptions; // u2
    private ExceptionIndexTable[] exceptionIndexTable; // numberOfExceptions
}
