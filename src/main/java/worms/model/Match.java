package worms.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Match {

    private final MatchStatus matchStatus;
    private final MatchConfiguration configuration;
    private final List<MatchObserver> observers;

    public Match(final MatchConfiguration configuration) {
        this.configuration = configuration;
        matchStatus = new MatchStatus();
        observers = new ArrayList<>();
    }

    public MatchStatus getStatus() {
        return matchStatus;
    }

    public void start() {
        matchStatus.setRunning(true);
        startNewTurn();
    }

    public void stop() {
        matchStatus.setRunning(false);
        update();
    }

    public void addPlayer(final Player player) {
        Collection<Player> players = matchStatus.getPlayers();
        players.add(player);
        update();
    }

    public void removePlayer(final Player player) {
        Collection<Player> players = matchStatus.getPlayers();
        players.remove(player);
        update();
    }

    public void endTurn(final Turn turn) {
        turn.end();
        startNewTurn();
    }

    private void startNewTurn() {
        final Turn turn = new Turn(this);
        final Collection<Turn> turns = matchStatus.getTurns();
        turns.add(turn);
        turn.start();
        update();
    }

    public void add(MatchObserver observer) {
        observers.add(observer);
    }

    public void remove(MatchObserver observer) {
        observers.remove(observer);
    }

    private void update() {
        observers.forEach(matchObserver -> {
            matchObserver.update(matchStatus);
        });
    }

}
