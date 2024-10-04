package hgu.isel.structure.attribute.type.target;

public class LocalVariableTarget implements TargetInformation{
    private byte[] tableLength; // u2

    public byte[] getTableLength() {
        return tableLength;
    }

    public void setTableLength(byte[] tableLength) {
        this.tableLength = tableLength;
    }

    public LocalVariableTarget(byte[] tableLength) {
        this.tableLength = tableLength;
    }
}
