package worms.actions.states;

import worms.actions.player.ChangeStateAction;
import worms.actions.player.PlayerAction;
import worms.actions.controller.ActivateAction;
import worms.actions.controller.GameAction;

public class WaitingState extends PlayerState {

    @Override
    public PlayerAction getAction(final GameAction gameAction) {
        return gameAction.execute(this);
    }

    @Override
    public PlayerAction execute(final ActivateAction action) {
        return new ChangeStateAction(new MovingState());
    }
}
