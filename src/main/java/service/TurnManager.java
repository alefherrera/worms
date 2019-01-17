package service;

import enums.Action;
import model.ActivePlayer;

import java.util.List;

public abstract class TurnManager {

    protected List<ActivePlayer> players;
    private Integer turn = 0;
    private ActivePlayer player;

    public Integer getTurn() {
        return turn;
    }

    protected void nextTurn() {
        turn++;
    }

    public void init(List<ActivePlayer> players) {
        this.players = players;
    }

    public ActivePlayer getCurrent() {
        return player;
    }

    protected void setCurrent(ActivePlayer player) {
        player.onAction(Action.ACTIVATE);
        this.player = player;
    }

    public abstract void next();
}
