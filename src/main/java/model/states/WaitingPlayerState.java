package model.states;

import model.Player;
import model.actions.ActivateAction;

class WaitingPlayerState extends PlayerState {

    WaitingPlayerState() {
        conditions.put(new ActivateAction(), this::activate);
    }

    private PlayerState activate(Player player) {
        return new MovingState();
    }

}
