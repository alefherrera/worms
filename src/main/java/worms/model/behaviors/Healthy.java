package worms.model.behaviors;

import worms.model.units.Health;
import worms.model.units.Shield;

public interface Healthy {

    Health getHealth();

    void setHealth(Health health);

    default Health addShield(final Shield shield) {
        final Health health = getHealth().addShield(shield);
        setHealth(health);
        return health;
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
