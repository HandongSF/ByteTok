package hgu.isel.structure.constant.type;

import hgu.isel.structure.constant.ConstantPoolInformation;

public class MethodTypeInformation implements ConstantPoolInformation {
    private byte tag;
    private byte[] descriptorIndex; // u2

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte[] getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(byte[] descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public MethodTypeInformation(byte tag, byte[] descriptorIndex) {
        this.tag = tag;
        this.descriptorIndex = descriptorIndex;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nMethodTypeInformation: ");
        stringBuilder.append(String.format("%02X", tag));

        for(byte b : descriptorIndex) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
