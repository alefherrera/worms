package model.states;

import enums.MovementDirection;
import model.Action;
import model.Player;
import model.PlayerState;
import model.states.AimingPlayerState;

public class MovingState implements PlayerState {

    public PlayerState onAction(Action action, Player player) {
        switch (action) {
            case RIGHT:
                player.move(MovementDirection.RIGHT);
                return this;
            case LEFT:
                player.move(MovementDirection.LEFT);
                return this;
            case EXECUTE:
                return new AimingPlayerState();
            default:
                return this;
        }
    }
}
