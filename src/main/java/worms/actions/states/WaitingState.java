package worms.actions.states;

import worms.Character;
import worms.actions.controller.ActivateAction;
import worms.actions.controller.GameAction;

public class WaitingState extends CharacterState {

    public WaitingState(final Character character) {
        super(character);
    }

    @Override
    public CharacterState onAction(final GameAction gameAction) {
        return gameAction.execute(this);
    }

    @Override
    public CharacterState execute(final ActivateAction action) {
        return new MovingState(character);
    }
}
