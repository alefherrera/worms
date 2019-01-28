package service;

import model.Player;

import java.util.List;

public class SecuencialTurnManager extends TurnManager {

    public SecuencialTurnManager(List<Player> players) {
        super(players, 0);
    }

    public void next() {
        int i = players.indexOf(getCurrent());
        int next = i + 1;
        if (next == players.size()) {
            nextTurn();
            next = 0;
        }
        setCurrent(players.get(next));
    }

}
