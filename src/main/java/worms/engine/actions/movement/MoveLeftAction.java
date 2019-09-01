package worms.engine.actions.movement;

import worms.engine.actions.Action;
import worms.model.Movable;

import java.util.Objects;

public class MoveLeftAction implements Action<Movable> {

    @Override
    public Movable execute(final Movable target) {
        target.moveLeft();
        return target;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        return Objects.equals(getClass(), o.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
