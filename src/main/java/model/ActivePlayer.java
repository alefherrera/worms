package model;

import model.actions.Action;
import model.elements.Player;
import model.states.PlayerState;
import model.states.WaitingPlayerState;

public class ActivePlayer implements ControllerListener {

    private final Player player;
    private transient final Controller controller;
    private transient PlayerState state;

    ActivePlayer(Controller controller, Player player) {
        this.controller = controller;
        controller.addListener(this);
        this.player = player;
        this.state = new WaitingPlayerState();
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
