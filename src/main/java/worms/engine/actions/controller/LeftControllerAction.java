package worms.engine.actions.controller;

import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.states.MovingState;

public class LeftControllerAction extends ControllerAction {

    @Override
    public PlayerAction getAction(final MovingState state) {
        return state.getAction(this);
    }
}
