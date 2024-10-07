package hgu.isel.structure.attribute.type.annotation;

import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

public class ElementValue {
    private byte tag;
    private ElementUnion elementUnion;

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public ElementUnion getElementUnion() {
        return elementUnion;
    }

    public void setElementUnion(ElementUnion elementUnion) {
        this.elementUnion = elementUnion;
    }

    public ElementValue(byte tag, ElementUnion elementUnion) {
        this.tag = tag;
        this.elementUnion = elementUnion;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append(String.format("%02X", tag));
        stringBuilder.append(elementUnion.toString());

        return stringBuilder.toString();
    }


}
