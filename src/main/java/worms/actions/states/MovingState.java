package worms.actions.states;

import worms.actions.character.CharacterAction;
import worms.actions.character.MoveLeftAction;
import worms.actions.character.MoveRightAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;

public class MovingState extends CharacterState {

    @Override
    public CharacterAction getAction(final GameAction gameAction) {
        return gameAction.execute(this);
    }

    @Override
    public CharacterAction execute(final RightControllerAction action) {
        return new MoveRightAction();
    }

    @Override
    public CharacterAction execute(final LeftControllerAction action) {
        return new MoveLeftAction();
    }
}
