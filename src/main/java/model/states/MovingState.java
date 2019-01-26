package model.states;

import model.Player;
import model.actions.ExecuteAction;
import model.actions.LeftAction;
import model.actions.RightAction;

class MovingState extends PlayerState {

    MovingState(Player player) {
        super("MOVING", player);
        conditions.put(new RightAction(), this::moveRight);
        conditions.put(new LeftAction(), this::moveLeft);
        conditions.put(new ExecuteAction(), this::changeState);
    }

    private PlayerState moveRight() {
        player.moveRight();
        return this;
    }

    private PlayerState moveLeft() {
        player.moveLeft();
        return this;
    }

    private PlayerState changeState() {
        return new AimingPlayerState(player);
    }

}
