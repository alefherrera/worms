package service;

import model.ActivePlayer;
import model.actions.ActivateAction;

import java.util.List;

public abstract class TurnManager {

    transient final List<ActivePlayer> players;
    private Integer turn = 0;
    private ActivePlayer player;

    public Integer getTurn() {
        return turn;
    }

    void nextTurn() {
        turn++;
    }

    TurnManager(List<ActivePlayer> players, Integer initial) {
        this.players = players;
        setCurrent(players.get(initial));
    }

    public ActivePlayer getCurrent() {
        return player;
    }

    void setCurrent(ActivePlayer player) {
        player.onAction(new ActivateAction());
        this.player = player;
    }

    public abstract void next();
}
