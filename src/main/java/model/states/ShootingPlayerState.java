package model.states;

import enums.Action;
import model.elements.Player;

public class ShootingPlayerState implements PlayerState {

    public PlayerState onAction(Action action, Player player) {
        switch (action) {
            case RIGHT:
            case UP:
                player.increasePower();
                return this;
            case LEFT:
            case DOWN:
                player.decreasePower();
                return this;
            case EXECUTE:
                player.shot();
                return new WaitingPlayerState();
            case CANCEL:
                return new AimingPlayerState();
        }
        return this;
    }

    @Override
    public String toString() {
        return "ShootingPlayerState{}";
    }
}
