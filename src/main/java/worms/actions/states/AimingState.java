package worms.actions.states;

import worms.actions.player.PlayerAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.RightControllerAction;

public class AimingState extends PlayerState {

    @Override
    public PlayerAction getAction(final GameAction gameAction) {
        return gameAction.getAction(this);
    }

    @Override
    public PlayerAction getAction(final RightControllerAction action) {
        return null;
    }
}
