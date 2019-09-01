package worms.model.units;

import java.util.Objects;

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

    public Position translateX(int value) {
        return new Position(value, getY());
    }

    public Position translateY(int value) {
        return new Position(getX(), value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }
        final Position position = (Position) o;
        return Objects.equals(x, position.x) &&
                Objects.equals(y, position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
