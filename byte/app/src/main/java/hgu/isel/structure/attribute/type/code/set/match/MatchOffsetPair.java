package hgu.isel.structure.attribute.type.code.set.match;

public class MatchOffsetPair {
    private byte[] match;
    private byte[] offset;

    public MatchOffsetPair(byte[] match, byte[] offset) {
        this.match = match;
        this.offset = offset;
    }

    public byte[] getMatch() {
        return match;
    }

    public void setMatch(byte[] match) {
        this.match = match;
    }

    public byte[] getOffset() {
        return offset;
    }

    public void setOffset(byte[] offset) {
        this.offset = offset;
    }
}
