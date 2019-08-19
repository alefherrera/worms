package worms.actions.controller;

import worms.actions.player.PlayerAction;
import worms.actions.states.MovingState;

public class LeftControllerAction extends ControllerAction {

    @Override
    public PlayerAction execute(final MovingState state) {
        return state.execute(this);
    }
}
