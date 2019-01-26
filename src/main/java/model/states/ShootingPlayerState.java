package model.states;

import model.actions.*;
import model.elements.Player;

public class ShootingPlayerState extends PlayerState {

    public ShootingPlayerState() {
        map.put(new DownAction(), this::decreasePower);
        map.put(new LeftAction(), this::decreasePower);
        map.put(new RightAction(), this::increasePower);
        map.put(new UpAction(), this::increasePower);
        map.put(new ExecuteAction(), this::execute);
        map.put(new CancelAction(), this::cancel);
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
