package worms.engine.actions.health;

import worms.engine.actions.Action;
import worms.model.behaviors.Healthy;

public class DamageAction implements Action<Healthy> {

    private final Integer value;

    public DamageAction(Integer value) {
        this.value = value;
    }

    @Override
    public Healthy execute(final Healthy target) {
        target.damage(value);
        return target;
    }
}
