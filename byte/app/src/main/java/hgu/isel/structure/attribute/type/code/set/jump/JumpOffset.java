package hgu.isel.structure.attribute.type.code.set.jump;

public class JumpOffset {
    private byte[] info;

    public JumpOffset(byte[] info) {
        this.info = info;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : info) {
            stringBuilder.append(String.format("%02X", b));
        }



        return stringBuilder.toString();
    }
}
