package worms.engine.actions.power;

import worms.engine.actions.Action;
import worms.model.behaviors.Powerable;

public class IncreasePowerAction implements Action<Powerable> {

    @Override
    public Powerable execute(final Powerable target) {
        target.increase();
        return target;
    }
}
