package worms;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatchTest {

    @Test
    public void start() {
        Match match = new Match();
        match.start();
        MatchStatus matchStatus = match.getStatus();
        assertTrue(matchStatus.getRunning());
    }

    @Test
    public void exit() {
        Match match = new Match();
        MatchStatus matchStatus = match.getStatus();
        assertFalse(matchStatus.getRunning());
    }

    @Test
    public void exitAfterStart() {
        Match match = new Match();
        match.start();
        match.stop();
        MatchStatus matchStatus = match.getStatus();
        assertFalse(matchStatus.getRunning());
    }

    @Test
    public void addPlayer() {
        Match match = new Match();
        Player player = new Player();
        match.addPlayer(player);
        MatchStatus matchStatus = match.getStatus();
        assertTrue(matchStatus.getPlayers().contains(player));
    }

    @Test
    public void removePlayerAfterAdd() {
        Match match = new Match();
        Player player = new Player();
        match.addPlayer(player);
        MatchStatus matchStatus = match.getStatus();
        assertTrue(matchStatus.getPlayers().contains(player));
        match.removePlayer(player);
        assertFalse(matchStatus.getPlayers().contains(player));
    }

}
