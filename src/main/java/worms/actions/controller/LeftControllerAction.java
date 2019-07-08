package worms.actions.controller;

import worms.actions.states.CharacterState;
import worms.actions.states.MovingState;

public class LeftControllerAction extends ControllerAction {

    @Override
    public CharacterState execute(final MovingState state) {
        return state.execute(this);
    }
}
