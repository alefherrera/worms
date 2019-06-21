package worms;


import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void createMatch() {
        final Game game = new Game();
        final MatchConfiguration configuration = new MatchConfiguration();
        Match match = game.createMatch(configuration);
        assertNotNull(match);
    }

    @Test
    public void start() {
        final Game game = new Game();
        game.start();
        final GameStatus gameStatus = game.getStatus();
        assertTrue(gameStatus.getRunning());
    }

    @Test
    public void exit() {
        final Game game = new Game();
        game.exit();
        final GameStatus gameStatus = game.getStatus();
        assertFalse(gameStatus.getRunning());
    }

}