package model.states;

import model.Player;
import model.StatType;
import model.actions.*;

class AimingPlayerState extends PlayerState {

    AimingPlayerState(Player player) {
        super("AIMING", player);
        conditions.put(new DownAction(), this::increaseAngle);
        conditions.put(new LeftAction(), this::decreaseAngle);
        conditions.put(new RightAction(), this::increaseAngle);
        conditions.put(new UpAction(), this::decreaseAngle);
        conditions.put(new ExecuteAction(), this::execute);
        conditions.put(new CancelAction(), this::cancel);
    }

    private PlayerState cancel() {
        return new MovingState(player);
    }

    private PlayerState execute() {
        return new ShootingPlayerState(player);
    }

    private PlayerState decreaseAngle() {
        player.decrease(StatType.ANGLE);
        return this;
    }

    private PlayerState increaseAngle() {
        player.increase(StatType.ANGLE);
        return this;
    }

}
