package hgu.isel.structure.attribute.type.annotation;

public class ElementValuePairs {
    private byte[] elementNameIndex; // u2
    private ElementValue value;

    public byte[] getElementNameIndex() {
        return elementNameIndex;
    }

    public void setElementNameIndex(byte[] elementNameIndex) {
        this.elementNameIndex = elementNameIndex;
    }

    public ElementValue getValue() {
        return value;
    }

    public void setValue(ElementValue value) {
        this.value = value;
    }

    public ElementValuePairs(byte[] elementNameIndex, ElementValue value) {
        this.elementNameIndex = elementNameIndex;
        this.value = value;
    }
}
