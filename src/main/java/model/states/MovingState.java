package model.states;

import enums.MovementDirection;
import enums.Action;
import model.elements.Player;
import model.PlayerState;

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
