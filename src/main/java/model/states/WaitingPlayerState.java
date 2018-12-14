package model.states;

import model.Action;
import model.Player;
import model.PlayerState;
import model.states.MovingState;

public class WaitingPlayerState implements PlayerState {
    public PlayerState onAction(Action action, Player player) {
        if (action == Action.ACTIVATE) {
            return new MovingState();
        }
        return this;
    }
}
