package worms.model;

import worms.engine.Size;

public abstract class Element {

    private Size size;

    public Element(final Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }
}
