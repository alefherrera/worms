package worms.engine.actions.aim;

import worms.engine.actions.Action;
import worms.model.behaviors.Aimeable;

import java.util.Objects;

public class IncreaseAngleAction implements Action<Aimeable> {

    @Override
    public Aimeable execute(final Aimeable target) {
        target.increaseAngle();
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
