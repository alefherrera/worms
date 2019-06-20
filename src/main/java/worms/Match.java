package worms;

import java.util.Collection;

public class Match {

    private final MatchStatus matchStatus;

    public Match() {
        matchStatus = new MatchStatus();
    }

    public MatchStatus getStatus() {
        return matchStatus;
    }

    public void start() {
        matchStatus.setRunning(true);
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
}
