package worms.engine;

import org.junit.Test;
import worms.model.Player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class MatchTest {

    @Test
    public void start() {
        final MatchConfiguration configuration = new MatchConfiguration();
        final Match match = new Match(configuration);
        match.start();
        final MatchStatus matchStatus = match.getStatus();
        assertTrue(matchStatus.getRunning());
    }

    @Test
    public void exit() {
        final MatchConfiguration configuration = new MatchConfiguration();
        final Match match = new Match(configuration);
        final MatchStatus matchStatus = match.getStatus();
        assertFalse(matchStatus.getRunning());
    }

    @Test
    public void exitAfterStart() {
        final MatchConfiguration configuration = new MatchConfiguration();
        final Match match = new Match(configuration);
        match.start();
        match.stop();
        final MatchStatus matchStatus = match.getStatus();
        assertFalse(matchStatus.getRunning());
    }

    @Test
    public void addPlayer() {
        final MatchConfiguration configuration = new MatchConfiguration();
        final Match match = new Match(configuration);
        final Player player = mock(Player.class);
        match.addPlayer(player);
        final MatchStatus matchStatus = match.getStatus();
        assertTrue(matchStatus.getPlayers().contains(player));
    }

    @Test
    public void removePlayerAfterAdd() {
        final MatchConfiguration configuration = new MatchConfiguration();
        final Match match = new Match(configuration);
        final Player player = mock(Player.class);
        match.addPlayer(player);
        final MatchStatus matchStatus = match.getStatus();
        assertTrue(matchStatus.getPlayers().contains(player));
        match.removePlayer(player);
        assertFalse(matchStatus.getPlayers().contains(player));
    }

}
