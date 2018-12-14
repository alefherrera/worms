package model.states;

import enums.Action;
import model.elements.Player;

public class WaitingPlayerState implements PlayerState {
    public PlayerState onAction(Action action, Player player) {
        if (action == Action.ACTIVATE) {
            return new MovingState();
        }
        return this;
    }
}
