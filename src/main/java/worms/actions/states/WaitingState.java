package worms.actions.states;

import worms.Character;
import worms.actions.controller.ActivateAction;

public class WaitingState extends CharacterState {

    @Override
    public CharacterState onAction(final ActivateAction action, final Character character) {
        return new MovingState();
    }
}
