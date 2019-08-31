package worms.engine.actions.states;

import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.ActivateAction;
import worms.engine.actions.controller.GameAction;

public class WaitingState extends PlayerState {

    @Override
    public PlayerAction getAction(final GameAction gameAction) {
        return gameAction.getAction(this);
    }

    @Override
    public PlayerAction getAction(final ActivateAction action) {
        return new ChangeStateAction(new MovingState());
    }
}
