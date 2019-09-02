package worms.engine.actions.power;

import worms.engine.actions.Action;
import worms.model.behaviors.Powerable;

import java.util.Objects;

public class DecreasePowerAction implements Action<Powerable> {

    @Override
    public Powerable execute(final Powerable target) {
        target.decrease();
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
