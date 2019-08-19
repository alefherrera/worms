package worms.actions.controller;

import worms.actions.player.PlayerAction;
import worms.actions.states.WaitingState;

public class ActivateAction extends GameAction {

    @Override
    public PlayerAction execute(final WaitingState state) {
        return state.execute(this);
    }
}
