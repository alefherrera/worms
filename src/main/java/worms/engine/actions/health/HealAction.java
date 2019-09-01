package worms.engine.actions.health;

import worms.engine.actions.Action;
import worms.model.Healthy;

public class HealAction implements Action<Healthy> {

    private final Integer value;

    public HealAction(Integer value) {
        this.value = value;
    }

    @Override
    public Healthy execute(final Healthy target) {
        target.restore(value);
        return target;
    }
}
