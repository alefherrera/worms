package worms.model;

public class Position {

    private final Integer x, y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Position moveLeft(final int delta) {
        return new Position(getX() - delta, getY());
    }

    public Position moveRight(final int delta) {
        return new Position(getX() + delta, getY());
    }
}
