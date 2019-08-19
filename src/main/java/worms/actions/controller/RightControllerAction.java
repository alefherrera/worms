package worms.actions.controller;

import worms.actions.character.CharacterAction;
import worms.actions.states.MovingState;

public class RightControllerAction extends ControllerAction {

    @Override
    public CharacterAction execute(final MovingState state) {
        return state.execute(this);
    }
}
