package worms;


import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void createMatch() {
        Game game = new Game();
        MatchConfiguration configuration = new MatchConfiguration();
        Match match = game.createMatch(configuration);
        assertNotNull(match);
    }

    @Test
    public void start() {
        Game game = new Game();
        game.start();
        GameStatus gameStatus = game.getStatus();
        assertTrue(gameStatus.getRunning());
    }

    @Test
    public void exit() {
        Game game = new Game();
        game.exit();
        GameStatus gameStatus = game.getStatus();
        assertFalse(gameStatus.getRunning());
    }

}