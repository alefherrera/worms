package model;

public class WaitingStance implements Stance {
    public Stance onAction(Action action, Player player) {
        return this;
    }
}
