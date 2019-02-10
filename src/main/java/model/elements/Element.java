package model.elements;

import model.Looper;
import model.Position;
import model.Size;

import java.time.LocalTime;

public abstract class Element {

    private final Size size;

    private final String type;

    protected Position position;

    public Element(Size size) {
        this.size = size;
        type = this.getClass().getSimpleName();
    }

    public Position getPosition() {
        return position;
    }

    public void refresh(LocalTime time, Looper looper) {

    }

    public Size getSize() {
        return size;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
