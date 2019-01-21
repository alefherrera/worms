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
        Player player = new Player("player1", configuration);
        player.setPosition(new Position(0d, 0d));
        player.move(MovementDirection.RIGHT);
        player.move(MovementDirection.RIGHT);
        assertEquals(Double.valueOf(20d), player.getPosition().getX());
    }

    @Test
    public void receiveDamage() {
        Configuration configuration = new Configuration();
        configuration.setMovingSpeed(10D);
        final Double INITIAL_HEALTH = 100D;
        final Double DAMAGE = 20D;
        configuration.setInitialHealth(INITIAL_HEALTH);
        Player player = new Player("player1", configuration);
        assertEquals(INITIAL_HEALTH, player.getHealth());
        player.receiveDamage(DAMAGE);
        final Double expectedHealth = INITIAL_HEALTH - DAMAGE;
        assertEquals(expectedHealth, player.getHealth());
    }
}