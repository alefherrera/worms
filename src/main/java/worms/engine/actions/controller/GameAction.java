package worms.engine.actions.controller;

import worms.engine.actions.player.EmptyPlayerAction;
import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.states.AimingState;
import worms.engine.actions.states.MovingState;
import worms.engine.actions.states.ShootingState;
import worms.engine.actions.states.WaitingState;

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
