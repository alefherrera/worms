package worms.model;

import worms.engine.actions.ActivateAction;
import worms.engine.actions.DeactivateAction;

import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class Turn {

    public static final int DELAY = 5000;
    private final AtomicBoolean isActive;
    private final Iterator<Player> iterator;
    private final Consumer<Turn> onEnd;
    private Timer timer;

    public Turn(Iterator<Player> iterator, Consumer<Turn> onEnd) {
        this.iterator = iterator;
        this.onEnd = onEnd;
        isActive = new AtomicBoolean(false);
        timer = new Timer(true);
    }

    public void next() {
        if (iterator.hasNext()) {
            activateCurrentPlayer(iterator.next());
        } else {
            end();
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
        timer.cancel();
        onEnd.accept(this);
    }
}
