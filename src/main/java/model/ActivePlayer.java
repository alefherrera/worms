package model;

import enums.Action;
import model.elements.Player;
import model.states.PlayerState;

public class ActivePlayer {

    private Player player;
    private PlayerState state;
    private Controller controller;

    public ActivePlayer(Controller controller, Player player, PlayerState state) {
        this.controller = controller;
        this.player = player;
        this.state = state;
        onAction(Action.ACTIVATE);
    }

    public Player getPlayer() {
        return player;
    }

    public Controller getController() {
        return controller;
    }

    public void onAction(Action action) {
        this.state = this.state.onAction(action, player);
    }
}
