package service;

import model.actions.Action;
import model.ActivePlayer;
import model.actions.ActivateAction;

import java.util.List;

public abstract class TurnManager {

    protected final List<ActivePlayer> players;
    private Integer turn = 0;
    private ActivePlayer player;

    public Integer getTurn() {
        return turn;
    }

    protected void nextTurn() {
        turn++;
    }

    public TurnManager(List<ActivePlayer> players, Integer initial) {
        this.players = players;
        setCurrent(players.get(initial));
    }

    public ActivePlayer getCurrent() {
        return player;
    }

    protected void setCurrent(ActivePlayer player) {
        player.onAction(new ActivateAction());
        this.player = player;
    }

    public abstract void next();

    @Override
    public String toString() {
        return "TurnManager{" +
                "players=" + players +
                ", turn=" + turn +
                ", player=" + player.getPlayer() +
                '}';
    }
}
