package model;

import enums.Action;
import model.elements.Player;
import model.states.PlayerState;
import model.states.WaitingPlayerState;

import java.util.Objects;

public class ActivePlayer implements ControllerListener {

    private final Player player;
    private final Controller controller;
    private PlayerState state;

    public ActivePlayer(Controller controller, Player player) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivePlayer that = (ActivePlayer) o;
        return Objects.equals(player, that.player) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, state);
    }

    @Override
    public String toString() {
        return "ActivePlayer{" +
                "player=" + player +
                ", controller=" + controller +
                ", state=" + state +
                '}';
    }
}
