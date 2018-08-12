package model;

public class AimingStance implements Stance {

    public Stance onAction(Action action, Player player) {
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
                return new ShootingStance();
            case CANCEL:
                return new MovingStance();
        }
        return this;
    }
}
