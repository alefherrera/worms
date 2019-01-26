package model.states;

import model.Player;
import model.actions.ActivateAction;

class WaitingPlayerState extends PlayerState {

    WaitingPlayerState(Player player) {
        super("WAITING", player);
        conditions.put(new ActivateAction(), this::activate);
    }

    private PlayerState activate() {
        return new MovingState(player);
    }

}
