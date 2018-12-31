package model;

import enums.Action;
import model.config.Configuration;
import model.elements.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    public static final Double MOVING_SPEED = 10d;
    public static final Double AIMING_SPEED = 2d;
    public static final Double POWER_SPEED = 1d;
    public static final Double ZERO = Double.valueOf(0d);

    private Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setMovingSpeed(MOVING_SPEED);
        configuration.setAimingSpeed(AIMING_SPEED);
        configuration.setPowerSpeed(POWER_SPEED);
        return configuration;
    }

    @Test
    public void onAction() {
        Configuration configuration = getConfiguration();
        Game game = new Game(configuration);
        Player player = new Player(game);

        game.start();

        game.onAction(Action.RIGHT);

        assertEquals(MOVING_SPEED, player.getPosition().getX());

        game.onAction(Action.LEFT);

        assertEquals(ZERO, player.getPosition().getX());

        game.onAction(Action.EXECUTE);

        game.onAction(Action.RIGHT);

        assertEquals(ZERO, player.getPosition().getX());

        assertEquals(AIMING_SPEED, player.getAngle());

        game.onAction(Action.EXECUTE);

        game.onAction(Action.RIGHT);

        assertEquals(POWER_SPEED, player.getPower());

    }
}