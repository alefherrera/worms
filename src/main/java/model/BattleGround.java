package model;

import model.elements.Element;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void refresh(LocalTime time, Looper looper) {
        elements.forEach(element -> element.refresh(time, looper, getOtherElements(element)));
    }

    private List<Element> getOtherElements(Element element) {
        return elements.stream().filter(x -> !x.equals(element)).collect(Collectors.toList());
    }
}
