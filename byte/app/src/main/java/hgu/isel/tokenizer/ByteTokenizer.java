package hgu.isel.tokenizer;

public class ByteTokenizer {
    private ByteStructure byteStructure;

    public ByteTokenizer(ByteStructure byteStructure) {
        this.byteStructure = byteStructure;
    }

    public ByteStructure getByteStructure() {
        return byteStructure;
    }

    public void setByteStructure(ByteStructure byteStructure) {
        this.byteStructure = byteStructure;
    }

    public void createVocabulary() {

    }
}
