package worms.model;

import worms.model.units.Aim;
import worms.model.units.Power;

import java.util.Objects;

public class Weapon {

    private final String name;

    public Weapon(final String name) {
        this.name = name;
    }

    public void shot(final Aim aim, final Power power) {

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Weapon)) {
            return false;
        }
        final Weapon weapon = (Weapon) o;
        return Objects.equals(name, weapon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
