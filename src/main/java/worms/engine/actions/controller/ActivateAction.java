package worms.engine.actions.controller;

import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.states.WaitingState;

public class ActivateAction extends GameAction {

    @Override
    public PlayerAction getAction(final WaitingState state) {
        return state.getAction(this);
    }
}
