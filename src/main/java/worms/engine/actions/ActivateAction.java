package worms.engine.actions;

import worms.engine.actions.controller.GameAction;
import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.states.IdleState;

public class ActivateAction extends GameAction {

    @Override
    public PlayerAction getAction(final IdleState state) {
        return state.getAction(this);
    }
}
