package worms.model;

public abstract class Element {

    private Size size;

    public Element(final Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }
}
