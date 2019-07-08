package worms.actions.controller;

import worms.actions.states.AimingState;
import worms.actions.states.CharacterState;
import worms.actions.states.MovingState;
import worms.actions.states.ShootingState;
import worms.actions.states.WaitingState;

public abstract class GameAction {

    public CharacterState execute(WaitingState state) {
        return state;
    }

    public CharacterState execute(MovingState state) {
        return state;
    }

    public CharacterState execute(AimingState state) {
        return state;
    }

    public CharacterState execute(ShootingState state) {
        return state;
    }

}
