package worms.actions.controller;

import worms.actions.character.CharacterAction;
import worms.actions.states.WaitingState;

public class ActivateAction extends GameAction {

    @Override
    public CharacterAction execute(final WaitingState state) {
        return state.execute(this);
    }
}
