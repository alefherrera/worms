package worms.actions.controller;

import worms.actions.player.PlayerAction;
import worms.actions.states.MovingState;

public class LeftControllerAction extends ControllerAction {

    @Override
    public PlayerAction getAction(final MovingState state) {
        return state.getAction(this);
    }
}
