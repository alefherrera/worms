package model;

import model.actions.Action;
import model.config.Configuration;
import service.TurnManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Game implements ControllerListener {

    private final Collection<Match> matches;
    private final Looper looper;

    public Game(Looper looper) {
        this.looper = looper;
        this.matches = new ArrayList<>();
    }

    public void start() {
        looper.start(this);
    }

    public void finish() {
        looper.stop();
    }

    public GameStatus getStatus() {
        return new GameStatus(matches);
    }

    public Match createMatch(Configuration configuration, Function<List<Player>, TurnManager> turnManagerSupplier) {
        Match match = new Match(this, configuration, turnManagerSupplier);
        matches.add(match);
        return match;
    }

    @Override
    public void onAction(Action action) {
        looper.needToRefresh();
    }
}
