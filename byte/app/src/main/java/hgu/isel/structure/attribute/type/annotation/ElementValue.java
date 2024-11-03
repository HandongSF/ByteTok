package hgu.isel.structure.attribute.type.annotation;

import hgu.isel.structure.attribute.type.annotation.elemet.ElementUnion;

import java.util.ArrayList;
import java.util.List;

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


    public List<String> tokenize() {
        List<String> output = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[Element Value Tag] ");
        stringBuilder.append(String.format("%02X", tag));
        output.add(stringBuilder.toString());
        stringBuilder.setLength(0);

        for(String s : elementUnion.tokenize()) {
            stringBuilder.append("[Element Value] ");
            stringBuilder.append(s);
            output.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }


        return output;
    }


}
