package worms.actions.states;

import worms.actions.character.CharacterAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.RightControllerAction;

public class ShootingState extends CharacterState {

    @Override
    public CharacterAction getAction(final GameAction gameAction) {
        return gameAction.execute(this);
    }

    @Override
    public CharacterAction execute(final RightControllerAction action) {
        return null;
    }
}
