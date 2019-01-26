package model.states;

import model.actions.*;
import model.elements.Player;

public class AimingPlayerState extends PlayerState {

    public AimingPlayerState() {
        map.put(new DownAction(), this::increaseAngle);
        map.put(new LeftAction(), this::decreaseAngle);
        map.put(new RightAction(), this::increaseAngle);
        map.put(new UpAction(), this::decreaseAngle);
        map.put(new ExecuteAction(), this::execute);
        map.put(new CancelAction(), this::cancel);
    }

    private PlayerState cancel(Player player) {
        return new MovingState();
    }

    private PlayerState execute(Player player) {
        return new ShootingPlayerState();
    }

    private PlayerState decreaseAngle(Player player) {
        player.decreaseAngle();
        return this;
    }

    private PlayerState increaseAngle(Player player) {
        player.increaseAngle();
        return this;
    }

}
