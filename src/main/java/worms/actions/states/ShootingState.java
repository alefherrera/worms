package worms.actions.states;

import worms.Character;
import worms.actions.controller.GameAction;
import worms.actions.controller.RightControllerAction;

public class ShootingState extends CharacterState {

    public ShootingState(final Character character) {
        super(character);
    }

    @Override
    public CharacterState onAction(final GameAction gameAction) {
        return gameAction.execute(this);
    }

    @Override
    public CharacterState execute(final RightControllerAction action) {
        return null;
    }
}
