package worms.actions.states;

import worms.Character;
import worms.actions.controller.ActivateAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;

public abstract class CharacterState {

    protected final Character character;

    public CharacterState(Character character) {
        this.character = character;
    }

    public abstract CharacterState onAction(final GameAction gameAction);

    public CharacterState execute(final RightControllerAction action) {
        return this;
    }

    public CharacterState execute(final ActivateAction action) {
        return this;
    }

    public CharacterState execute(final LeftControllerAction action) {
        return this;
    }
}
