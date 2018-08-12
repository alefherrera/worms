package model;

import enums.MovementDirection;

public class MovingStance implements Stance {

    public Stance onAction(Action action, Player player) {
        switch (action) {
            case RIGHT:
                player.move(MovementDirection.RIGHT);
                return this;
            case LEFT:
                player.move(MovementDirection.LEFT);
                return this;
            case EXECUTE:
                return new AimingStance();
            default:
                return this;
        }
    }
}
