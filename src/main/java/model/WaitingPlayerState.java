package model;

public class WaitingPlayerState implements PlayerState {
    public PlayerState onAction(Action action, Player player) {
        if (action == Action.ACTIVATE) {
            return new MovingState();
        }
        return this;
    }
}
