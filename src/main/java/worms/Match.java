package worms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Match {

    private final MatchStatus matchStatus;
    private final MatchConfiguration configuration;
    private final List<Turn> turns;

    public Match(final MatchConfiguration configuration) {
        this.configuration = configuration;
        matchStatus = new MatchStatus();
        turns = new ArrayList<>();
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
    }

    public void addPlayer(final Player player) {
        Collection<Player> players = matchStatus.getPlayers();
        players.add(player);
    }

    public void removePlayer(final Player player) {
        Collection<Player> players = matchStatus.getPlayers();
        players.remove(player);
    }

    public void endTurn(final Turn turn) {
        turn.end();
        startNewTurn();
    }

    private void startNewTurn() {
        final Turn turn = new Turn(this);
        turns.add(turn);
        turn.start();
    }
}
