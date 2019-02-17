package model;

import model.elements.Element;
import service.CollisionVerifier;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BattleGround extends Element {

    private transient final Looper looper;

    private final List<Element> elements;
    private transient final List<Element> toRemove;
    private transient final CollisionVerifier collisionVerifier;

    public BattleGround(Size size, Looper looper) {
        super(size);
        this.looper = looper;
        elements = new ArrayList<>();
        toRemove = new ArrayList<>();
        collisionVerifier = new CollisionVerifier();
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }

    public void refresh(LocalTime time) {
        elements.forEach(element -> element.refresh(time, this));
        toRemove.forEach(element ->
                elements.remove(element));
        toRemove.clear();
    }

    private List<Element> getOtherElements(Element element) {
        return elements.stream().filter(x -> !x.equals(element)).collect(Collectors.toList());
    }

    public void update(Element element) {
        List<Element> otherElements = getOtherElements(element);
        otherElements.forEach(otherElement -> {
            if (verifyCollision(element, otherElement)) {
                element.onCollision(otherElement);
            }
        });
        if (!verifyCollision(element, this)) {
            toRemove.add(element);
        }
        looper.needToRefresh();
    }

    private boolean verifyCollision(Element a, Element b) {
        return collisionVerifier.hasCollision(a, b);
    }
}
