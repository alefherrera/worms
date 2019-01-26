package model.states;

import model.actions.ActivateAction;
import model.elements.Player;

public class WaitingPlayerState extends PlayerState {

    public WaitingPlayerState() {
        map.put(new ActivateAction(), this::activate);
    }

    private PlayerState activate(Player player) {
        return new MovingState();
    }

}
