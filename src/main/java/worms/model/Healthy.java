package worms.model;

import worms.model.units.Health;

public interface Healthy {

    Health getHealth();

    void setHealth(Health health);

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
