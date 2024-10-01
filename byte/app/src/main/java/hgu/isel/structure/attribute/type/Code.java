package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.exception.ExceptionTable;

public class Code implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] maxStack; // u2
    private byte[] maxLocals; // u2
    private byte[] codeLength; // u4
    private byte[] code; // codeLength
    private byte[] exceptionTableLength; // u2
    private ExceptionTable[] exceptionTable; // exceptionTableLength
    private byte[] attributesCount; // u2
    private AttributeInformation[] attributes; // attributesCount
}
