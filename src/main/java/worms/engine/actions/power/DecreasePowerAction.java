package worms.engine.actions.power;

import worms.engine.actions.Action;
import worms.model.behaviors.Powerable;

public class DecreasePowerAction implements Action<Powerable> {

    @Override
    public Powerable execute(final Powerable target) {
        target.decrease();
        return target;
    }
}
