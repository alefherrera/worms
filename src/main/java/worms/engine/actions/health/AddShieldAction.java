package worms.engine.actions.health;

import worms.engine.actions.Action;
import worms.model.units.Shield;
import worms.model.behaviors.Healthy;

public class AddShieldAction implements Action<Healthy> {

    private final Shield shield;

    public AddShieldAction(final Shield shield) {
        this.shield = shield;
    }

    @Override
    public Healthy execute(final Healthy target) {
        target.addShield(shield);
        return target;
    }

}
