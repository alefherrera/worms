package worms.actions.states;

import worms.actions.character.ChangeStateAction;
import worms.actions.character.CharacterAction;
import worms.actions.controller.ActivateAction;
import worms.actions.controller.GameAction;

public class WaitingState extends CharacterState {

    @Override
    public CharacterAction getAction(final GameAction gameAction) {
        return gameAction.execute(this);
    }

    @Override
    public CharacterAction execute(final ActivateAction action) {
        return new ChangeStateAction(new MovingState());
    }
}
