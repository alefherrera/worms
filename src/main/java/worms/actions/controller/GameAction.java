package worms.actions.controller;

import worms.actions.player.EmptyPlayerAction;
import worms.actions.player.PlayerAction;
import worms.actions.states.AimingState;
import worms.actions.states.MovingState;
import worms.actions.states.ShootingState;
import worms.actions.states.WaitingState;

public abstract class GameAction {

    public PlayerAction getAction(WaitingState state) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(MovingState state) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(AimingState state) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(ShootingState state) {
        return new EmptyPlayerAction();
    }

}
