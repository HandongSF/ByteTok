package hgu.isel.analyzer;

import hgu.isel.structure.AttributeInformation;
import hgu.isel.structure.FieldInformation;
import hgu.isel.structure.MethodInformation;
import hgu.isel.structure.constant.ConstantPoolInformation;

public class ByteAnalyzer {
    private final byte[] bytes; // all bytes
    private byte[] magic; // u4
    private byte[] minorVersion; // u2
    private byte[] majorVersion; // u2
    private byte[] constantPoolCount; // u2
    private ConstantPoolInformation constantPoolInformation;
    private byte[] accessFlag; // u2
    private byte[] thisClass; // u2
    private byte[] superClass; // u2
    private byte[] interfacesCount; // u2
    private byte[] fieldsCount; // u2
    private FieldInformation fieldInformation;
    private byte[] methodsCount; // u2
    private MethodInformation methodInformation;
    private byte[] attributesCount; // u2
    private AttributeInformation attributeInformation;

    public ByteAnalyzer(byte[] bytes) {
        this.bytes = bytes;
    }

    public void analyze() {
        System.out.println(bytes.length);
    }
}
