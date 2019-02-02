package model;

import model.elements.Character;
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

    public void addElement(Character element) {
        elements.add(element);
    }
}
