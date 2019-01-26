package model.states;

import model.Player;
import model.StatType;
import model.actions.*;

class ShootingPlayerState extends PlayerState {

    ShootingPlayerState(Player player) {
        super("SHOOTING", player);
        conditions.put(new DownAction(), this::decreasePower);
        conditions.put(new LeftAction(), this::decreasePower);
        conditions.put(new RightAction(), this::increasePower);
        conditions.put(new UpAction(), this::increasePower);
        conditions.put(new ExecuteAction(), this::execute);
        conditions.put(new CancelAction(), this::cancel);
    }

    private PlayerState cancel() {
        return new AimingPlayerState(player);
    }

    private PlayerState execute() {
        player.shot();
        return new WaitingPlayerState(player);
    }

    private PlayerState increasePower() {
        player.increase(StatType.POWER);
        return this;
    }

    private PlayerState decreasePower() {
        player.decrease(StatType.POWER);
        return this;
    }

}
