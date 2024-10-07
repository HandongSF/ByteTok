package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;
import hgu.isel.structure.attribute.type.target.local.LocalVariableTargetTable;

public class LocalVariableTarget implements TargetInformation{
    private byte[] tableLength; // u2
    private LocalVariableTargetTable[] table;

    public byte[] getTableLength() {
        return tableLength;
    }

    public void setTableLength(byte[] tableLength) {
        this.tableLength = tableLength;
    }

    public LocalVariableTargetTable[] getTable() {
        return table;
    }

    public void setTable(LocalVariableTargetTable[] table) {
        this.table = table;
    }

    public LocalVariableTarget(byte[] tableLength, LocalVariableTargetTable[] table) {
        this.tableLength = tableLength;
        this.table = table;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : tableLength) {
            stringBuilder.append(String.format("%02X", b));
        }

        for(LocalVariableTargetTable t : table) {
            stringBuilder.append(t.toString());
        }

        return stringBuilder.toString();
    }
}
