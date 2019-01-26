package model.states;

import model.Player;
import model.actions.*;
import model.elements.Character;

class ShootingPlayerState extends PlayerState {

    ShootingPlayerState() {
        conditions.put(new DownAction(), this::decreasePower);
        conditions.put(new LeftAction(), this::decreasePower);
        conditions.put(new RightAction(), this::increasePower);
        conditions.put(new UpAction(), this::increasePower);
        conditions.put(new ExecuteAction(), this::execute);
        conditions.put(new CancelAction(), this::cancel);
    }

    private PlayerState cancel(Player player) {
        return new AimingPlayerState();
    }

    private PlayerState execute(Player player) {
        player.shot();
        return new WaitingPlayerState();
    }

    private PlayerState increasePower(Player player) {
        player.increasePower();
        return this;
    }

    private PlayerState decreasePower(Player player) {
        player.decreasePower();
        return this;
    }

}
