package model.states;

import model.Player;
import model.actions.ExecuteAction;
import model.actions.LeftAction;
import model.actions.RightAction;

class MovingState extends PlayerState {

    MovingState() {
        conditions.put(new RightAction(), this::moveRight);
        conditions.put(new LeftAction(), this::moveLeft);
        conditions.put(new ExecuteAction(), this::changeState);
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
