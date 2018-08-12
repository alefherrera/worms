package model;

public class ShootingStance implements Stance {

    public Stance onAction(Action action, Player player) {
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
                return new MovingStance();
            case CANCEL:
                return new AimingStance();
        }
        return this;
    }
}
