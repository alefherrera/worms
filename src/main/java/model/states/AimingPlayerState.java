package model.states;

import model.Player;
import model.StatType;
import model.actions.*;
import model.elements.Character;

class AimingPlayerState extends PlayerState {

    AimingPlayerState() {
        conditions.put(new DownAction(), this::increaseAngle);
        conditions.put(new LeftAction(), this::decreaseAngle);
        conditions.put(new RightAction(), this::increaseAngle);
        conditions.put(new UpAction(), this::decreaseAngle);
        conditions.put(new ExecuteAction(), this::execute);
        conditions.put(new CancelAction(), this::cancel);
    }

    private PlayerState cancel(Player player) {
        return new MovingState();
    }

    private PlayerState execute(Player player) {
        return new ShootingPlayerState();
    }

    private PlayerState decreaseAngle(Player player) {
        player.decrease(StatType.ANGLE);
        return this;
    }

    private PlayerState increaseAngle(Player player) {
        player.increase(StatType.ANGLE);
        return this;
    }

}
