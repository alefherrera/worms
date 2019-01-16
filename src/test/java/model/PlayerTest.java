package model;

import enums.MovementDirection;
import model.config.Configuration;
import model.elements.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void move() {
        Configuration configuration = new Configuration();
        configuration.setMovingSpeed(10d);
        Game game = new Game(configuration);
        Player player = new Player("player1", game);
        player.setPosition(new Position(0d, 0d));
        player.move(MovementDirection.RIGHT);
        player.move(MovementDirection.RIGHT);
        assertEquals(Double.valueOf(20d), player.getPosition().getX());
    }
}