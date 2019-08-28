package worms.engine;

import worms.model.Player;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class Turn {

    private final Iterator<Player> playerIterator;
    private final Match match;
    private final AtomicBoolean isActive;
    private Player currentPlayer;

    public Turn(Match match) {
        this.match = match;
        isActive = new AtomicBoolean(false);
        this.playerIterator = match.getStatus().getPlayers().iterator();
    }

    public void next() {
        if (playerIterator.hasNext()) {
            currentPlayer = playerIterator.next();
        } else {
            match.endTurn(this);
        }
    }

    public void start() {
        isActive.set(true);
    }

    public void end() {
        isActive.set(false);
    }
}
