package worms.engine.actions.shot;

import worms.engine.actions.Action;
import worms.model.behaviors.Shooter;

import java.util.Objects;

public class SelectPreviousWeaponAction implements Action<Shooter> {
    @Override
    public Shooter execute(final Shooter target) {
        target.setPreviousWeapon();
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
