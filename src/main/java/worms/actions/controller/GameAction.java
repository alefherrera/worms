package worms.actions.controller;

import worms.actions.character.CharacterAction;
import worms.actions.character.EmptyAction;
import worms.actions.states.AimingState;
import worms.actions.states.MovingState;
import worms.actions.states.ShootingState;
import worms.actions.states.WaitingState;

public abstract class GameAction {

    public CharacterAction execute(WaitingState state) {
        return new EmptyAction();
    }

    public CharacterAction execute(MovingState state) {
        return new EmptyAction();
    }

    public CharacterAction execute(AimingState state) {
        return new EmptyAction();
    }

    public CharacterAction execute(ShootingState state) {
        return new EmptyAction();
    }

}
