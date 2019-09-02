package worms.engine.actions.shot;

import worms.engine.actions.Action;
import worms.model.behaviors.Shooter;

public class ShotAction implements Action<Shooter> {

    @Override
    public Shooter execute(final Shooter target) {
        target.shot();
        return target;
    }
}
