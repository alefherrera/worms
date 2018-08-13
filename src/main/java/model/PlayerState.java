package model;

public interface PlayerState {

    PlayerState onAction(Action action, Player player);

}
