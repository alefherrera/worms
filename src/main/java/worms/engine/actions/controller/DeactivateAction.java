package worms.engine.actions.controller;

import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.states.AimingState;
import worms.engine.actions.states.MovingState;
import worms.engine.actions.states.ShootingState;

public class DeactivateAction extends GameAction {

    @Override
    public PlayerAction getAction(final AimingState state) {
        return state.getAction(this);
    }

    @Override
    public PlayerAction getAction(final MovingState state) {
        return state.getAction(this);
    }

    @Override
    public PlayerAction getAction(final ShootingState state) {
        return state.getAction(this);
    }
}
