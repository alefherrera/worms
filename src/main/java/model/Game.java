package model;

import model.config.Configuration;
import service.TurnManager;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private final Collection<Match> matches;
    private final Looper looper;

    public Game(Looper looper) {
        this.looper = looper;
        this.matches = new ArrayList<>();
    }

    public void start() {
        looper.start();
        this.matches.forEach(match -> match.start());
    }

    public void finish() {
        looper.end();
    }

    public GameStatus getStatus() {
        return new GameStatus();
    }

    public Match createMatch(Configuration configuration, TurnManager turnManager) {
        Match match = new Match(configuration, turnManager);
        matches.add(match);
        return match;
    }
}
