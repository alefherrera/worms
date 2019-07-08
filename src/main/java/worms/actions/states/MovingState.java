package worms.actions.states;

import worms.Character;
import worms.actions.character.MoveLeftAction;
import worms.actions.character.MoveRightAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;

public class MovingState extends CharacterState {

    public MovingState(final Character character) {
        super(character);
    }

    @Override
    public CharacterState onAction(final GameAction gameAction) {
        return gameAction.execute(this);
    }

    @Override
    public CharacterState execute(final RightControllerAction action) {
        character.execute(new MoveRightAction());
        return this;
    }

    @Override
    public CharacterState execute(final LeftControllerAction action) {
        character.execute(new MoveLeftAction());
        return this;
    }
}
