package model.elements;

import model.Position;
import model.Size;

public class Element {

    private final Size size;

    private final String type;

    private Position position;

    public Element(Size size, Position position) {
        this.size = size;
        this.position = position;
        type = this.getClass().getSimpleName();
    }

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
