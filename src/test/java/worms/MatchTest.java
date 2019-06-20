package worms;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatchTest {

    @Test
    public void start() {
        final MatchConfiguration configuration = new MatchConfiguration();
        Match match = new Match(configuration);
        match.start();
        MatchStatus matchStatus = match.getStatus();
        assertTrue(matchStatus.getRunning());
    }

    @Test
    public void exit() {
        final MatchConfiguration configuration = new MatchConfiguration();
        Match match = new Match(configuration);
        MatchStatus matchStatus = match.getStatus();
        assertFalse(matchStatus.getRunning());
    }

    @Test
    public void exitAfterStart() {
        final MatchConfiguration configuration = new MatchConfiguration();
        Match match = new Match(configuration);
        match.start();
        match.stop();
        MatchStatus matchStatus = match.getStatus();
        assertFalse(matchStatus.getRunning());
    }

    @Test
    public void addPlayer() {
        final MatchConfiguration configuration = new MatchConfiguration();
        Match match = new Match(configuration);
        Player player = new Player();
        match.addPlayer(player);
        MatchStatus matchStatus = match.getStatus();
        assertTrue(matchStatus.getPlayers().contains(player));
    }

    @Test
    public void removePlayerAfterAdd() {
        final MatchConfiguration configuration = new MatchConfiguration();
        Match match = new Match(configuration);
        Player player = new Player();
        match.addPlayer(player);
        MatchStatus matchStatus = match.getStatus();
        assertTrue(matchStatus.getPlayers().contains(player));
        match.removePlayer(player);
        assertFalse(matchStatus.getPlayers().contains(player));
    }

}
