package model;

import enums.Action;
import model.config.Configuration;
import model.elements.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private static final Double MOVING_SPEED = 10d;
    private static final Double AIMING_SPEED = 2d;
    private static final Double POWER_SPEED = 1d;
    private static final Double ZERO = 0d;

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

    @Test
    public void nextTurnPlayer() {
        Configuration configuration = getConfiguration();
        Game game = new Game(configuration);
        Player player = new Player(game);
        Player player2 = new Player(game);

        game.start();

        assertEquals(player, game.getPlayer());
        //move
        game.onAction(Action.EXECUTE);
        //aim
        game.onAction(Action.EXECUTE);
        //shoot
        game.onAction(Action.EXECUTE);

        assertEquals(player2, game.getPlayer());

    }

    @Test
    public void removePlayer() {
        Configuration configuration = getConfiguration();
        Game game = new Game(configuration);
        Player player = new Player(game);
        Player player2 = new Player(game);
        Player player3 = new Player(game);

        game.start();

        assertEquals(player, game.getPlayer());
        //move
        game.onAction(Action.EXECUTE);
        //aim
        game.onAction(Action.EXECUTE);

        game.removePlayer(player2);

        //shoot
        game.onAction(Action.EXECUTE);

        assertEquals(player3, game.getPlayer());

    }
}