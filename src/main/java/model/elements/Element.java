package model.elements;

import model.Looper;
import model.Position;
import model.Size;

import java.time.LocalTime;
import java.util.List;

public abstract class Element {

    private final Size size;

    private final String type;

    protected Position position;

    public Element(Size size) {
        this.size = size;
        type = this.getClass().getSimpleName();
        position = new Position(0D, 0D);
    }

    public Position getPosition() {
        return position;
    }

    public void refresh(LocalTime time, Looper looper, List<Element> otherElements) {

    }

    public Size getSize() {
        return size;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
