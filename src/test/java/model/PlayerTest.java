package model;

import enums.MovementDirection;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void move() {
        Game game = new Game();
        game.setMovingSpeed(10d);
        Player player = new Player(game);
        player.setPosition(new Position(0d, 0d));
        player.move(MovementDirection.RIGHT);
        player.move(MovementDirection.RIGHT);
        assertEquals(Double.valueOf(20d), player.getPosition().getX());
    }
}