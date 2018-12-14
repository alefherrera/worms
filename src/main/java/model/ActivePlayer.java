package model;

import enums.Action;
import model.elements.Player;
import model.states.PlayerState;

public class ActivePlayer {

    private Player player;
    private PlayerState state;

    public ActivePlayer(Player player, PlayerState state) {
        this.player = player;
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public void onAction(Action action) {
        this.state = this.state.onAction(action, player);
    }
}
