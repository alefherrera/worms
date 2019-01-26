package model.states;

import model.actions.ExecuteAction;
import model.actions.LeftAction;
import model.actions.RightAction;
import model.elements.Player;

public class MovingState extends PlayerState {

    public MovingState() {
        map.put(new RightAction(), this::moveRight);
        map.put(new LeftAction(), this::moveLeft);
        map.put(new ExecuteAction(), this::changeState);
    }

    private PlayerState moveRight(Player player) {
        player.moveRight();
        return this;
    }

    private PlayerState moveLeft(Player player) {
        player.moveLeft();
        return this;
    }

    private PlayerState changeState(Player player) {
        return new AimingPlayerState();
    }

}
