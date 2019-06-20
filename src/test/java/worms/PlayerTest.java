package worms;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void joinMatch() {
        Player player = new Player();
        final Match match = new Match();
        player.join(match);
        MatchStatus matchStatus = match.getStatus();
        assertTrue(matchStatus.getPlayers().contains(player));
    }

}