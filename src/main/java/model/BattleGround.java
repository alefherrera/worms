package model;

import model.elements.Element;

import java.util.ArrayList;
import java.util.List;

public class BattleGround {

    private final Size size;

    private final List<Element> elements;

    public BattleGround(Size size) {
        this.size = size;
        elements = new ArrayList<>();
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }
}
