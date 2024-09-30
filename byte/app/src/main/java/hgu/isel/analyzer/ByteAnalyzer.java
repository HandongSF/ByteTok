package hgu.isel.analyzer;

import hgu.isel.structure.AttributeInformation;
import hgu.isel.structure.ConstantPoolInformation;
import hgu.isel.structure.FieldInformation;
import hgu.isel.structure.MethodInformation;

public class ByteAnalyzer {
    private final byte[] bytes;
    private byte[] magic;
    private byte[] minorVersion;
    private byte[] majorVersion;
    private byte[] constantPoolCount;
    private ConstantPoolInformation constantPoolInformation;
    private byte[] accessFlag;
    private byte[] thisClass;
    private byte[] superClass;
    private byte[] interfacesCount;
    private byte[] fieldsCount;
    private FieldInformation fieldInformation;
    private byte[] methodsCount;
    private MethodInformation methodInformation;
    private byte[] attributesCount;
    private AttributeInformation attributeInformation;

    public ByteAnalyzer(byte[] bytes) {
        this.bytes = bytes;
    }

    public void analyze() {
        System.out.println(bytes.length);
    }
}
