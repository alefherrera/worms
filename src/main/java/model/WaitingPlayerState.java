package model;

public class WaitingPlayerState implements PlayerState {
    public PlayerState onAction(Action action, Player player) {
        return this;
    }
}
