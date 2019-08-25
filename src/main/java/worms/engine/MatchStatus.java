package worms.engine;

import java.util.ArrayList;
import java.util.Collection;

public class MatchStatus {

    private Boolean isRunning = false;
    private Collection<Player> players = new ArrayList<>();

    public boolean getRunning() {
        return isRunning;
    }

    public void setRunning(final Boolean running) {
        isRunning = running;
    }

    public Collection<Player> getPlayers() {
        return players;
    }
}
