package worms.actions.states;

import worms.Character;
import worms.actions.controller.ActivateAction;
import worms.actions.controller.GameAction;

public abstract class CharacterState {

    public CharacterState onAction(final GameAction gameAction, final Character character) {
        return this;
    }

    public CharacterState onAction(final ActivateAction action, final Character character) {
        return this;
    }

}
