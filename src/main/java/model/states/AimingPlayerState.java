package model.states;

import enums.Action;
import model.*;
import model.elements.Player;

public class AimingPlayerState implements PlayerState {

    public PlayerState onAction(Action action, Player player) {
        switch (action) {
            case RIGHT:
            case DOWN:
                player.increaseAngle();
                return this;
            case LEFT:
            case UP:
                player.decreaseAngle();
                return this;
            case EXECUTE:
                return new ShootingPlayerState();
            case CANCEL:
                return new MovingState();
        }
        return this;
    }
}
