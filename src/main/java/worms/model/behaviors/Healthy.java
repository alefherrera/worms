package worms.model.behaviors;

import worms.model.units.Shield;
import worms.model.units.Health;
import worms.model.units.ShieldedHealth;

public interface Healthy {

    Health getHealth();

    void setHealth(Health health);

    default void addShield(final Shield shield) {
        setHealth(new ShieldedHealth(getHealth(), shield));
    }

    default Health damage(final Integer value) {
        final Health health = getHealth().damage(value);
        setHealth(health);
        return health;
    }

    default Health restore(final Integer value) {
        final Health health = getHealth().restore(value);
        setHealth(health);
        return health;
    }

}
