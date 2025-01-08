package hgu.isel.structure.attribute.type.target;

import hgu.isel.structure.attribute.type.annotation.elemet.union.Annotation;
import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;
import hgu.isel.structure.attribute.type.target.local.LocalVariableTargetTable;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> tokenize() {
        List<String> output = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        // output.add("[Local Variable Target Table Length]");
        for(byte b : tableLength) {
            stringBuilder.append(String.format("%02X", b));
        }
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(LocalVariableTargetTable c : table) {
            output.addAll(c.tokenize());
        }

        return output;
    }
}
