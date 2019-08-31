package worms.model;

import worms.engine.actions.controller.ActivateAction;
import worms.engine.actions.controller.DeactivateAction;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class Turn {

    public static final int DELAY = 5000;
    private final Iterator<Player> playerIterator;
    private final Match match;
    private final AtomicBoolean isActive;
    private Timer timer;

    public Turn(Match match) {
        this.match = match;
        isActive = new AtomicBoolean(false);
        this.playerIterator = match.getStatus().getPlayers().iterator();
        timer = new Timer(true);
    }

    public void next() {
        if (playerIterator.hasNext()) {
            activateCurrentPlayer(playerIterator.next());
        } else {
            match.endTurn(this);
        }
    }

    private void activateCurrentPlayer(Player player) {
        timer.purge();
        player.execute(new ActivateAction());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.execute(new DeactivateAction());
                next();
            }
        }, DELAY);
    }

    public void start() {
        isActive.set(true);
        next();

    }

    public void end() {
        isActive.set(false);
    }
}
