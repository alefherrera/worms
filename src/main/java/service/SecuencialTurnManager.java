package service;

import model.ActivePlayer;

import java.util.List;

public class SecuencialTurnManager extends TurnManager {

    @Override
    public void init(List<ActivePlayer> players) {
        super.init(players);
        setCurrent(players.get(0));
    }

    @Override
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
