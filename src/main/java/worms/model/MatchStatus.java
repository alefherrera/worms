package worms.model;

import java.util.ArrayList;
import java.util.Collection;

public class MatchStatus {

    private Boolean isRunning = false;
    private final Collection<Player> players = new ArrayList<>();
    private final Collection<Turn> turns = new ArrayList<>();

    public boolean getRunning() {
        return isRunning;
    }

    public void setRunning(final Boolean running) {
        isRunning = running;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public Collection<Turn> getTurns() {
        return turns;
    }
}
