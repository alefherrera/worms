package service;

import model.Player;
import model.actions.ActivateAction;

import java.util.List;

public abstract class TurnManager {

    transient final List<Player> players;
    private Integer turn = 0;
    private transient Player player;
    private String current;

    public Integer getTurn() {
        return turn;
    }

    void nextTurn() {
        turn++;
    }

    TurnManager(List<Player> players, Integer initial) {
        this.players = players;
        setCurrent(players.get(initial));
    }

    public Player getCurrent() {
        return player;
    }

    void setCurrent(Player player) {
        player.onAction(new ActivateAction());
        this.player = player;
        this.current = player.getName();
    }

    public abstract void next();
}
