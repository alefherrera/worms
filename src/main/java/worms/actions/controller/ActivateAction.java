package worms.actions.controller;

import worms.actions.states.CharacterState;
import worms.actions.states.WaitingState;

public class ActivateAction extends GameAction {

    @Override
    public CharacterState execute(final WaitingState state) {
        return state.execute(this);
    }
}
