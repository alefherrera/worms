package model.elements;

import model.Position;
import model.Size;

public class Element {

    private Size size;

    private Position position;

    public Element() {
        position = Position.DEFAULT;
        size = new Size();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
