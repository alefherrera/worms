package model;

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
                return new MovingState();
            case CANCEL:
                return new AimingPlayerState();
        }
        return this;
    }
}
