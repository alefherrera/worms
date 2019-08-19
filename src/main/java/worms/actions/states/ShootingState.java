package worms.actions.states;

import worms.actions.player.PlayerAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.RightControllerAction;

public class ShootingState extends PlayerState {

    @Override
    public PlayerAction getAction(final GameAction gameAction) {
        return gameAction.execute(this);
    }

    @Override
    public PlayerAction execute(final RightControllerAction action) {
        return null;
    }
}
