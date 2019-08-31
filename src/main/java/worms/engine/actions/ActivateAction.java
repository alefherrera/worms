package worms.engine.actions;

import worms.engine.actions.controller.GameAction;
import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.states.WaitingState;

public class ActivateAction extends GameAction {

    @Override
    public PlayerAction getAction(final WaitingState state) {
        return state.getAction(this);
    }
}
