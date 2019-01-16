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
        Controller controller = new Controller("slot1");
        Player player = new Player("player1", game);
        game.addPlayer(player, controller);

        game.start();

        game.doAction(controller, Action.RIGHT);

        assertEquals(MOVING_SPEED, player.getPosition().getX());

        game.doAction(controller, Action.LEFT);

        assertEquals(ZERO, player.getPosition().getX());

        game.doAction(controller, Action.EXECUTE);

        game.doAction(controller, Action.RIGHT);

        assertEquals(ZERO, player.getPosition().getX());

        assertEquals(AIMING_SPEED, player.getAngle());

        game.doAction(controller, Action.EXECUTE);

        game.doAction(controller, Action.RIGHT);

        assertEquals(POWER_SPEED, player.getPower());

    }

    @Test
    public void nextTurnPlayer() {
        Configuration configuration = getConfiguration();
        Game game = new Game(configuration);
        Controller controller = new Controller("slot1");
        Controller controller2 = new Controller("slot2");
        Player player = new Player("player1", game);
        Player player2 = new Player("player2", game);
        game.addPlayer(player, controller);
        game.addPlayer(player2, controller2);

        game.start();

        assertEquals(player, game.getPlayer());
        //move
        game.doAction(controller2, Action.EXECUTE);
        //aim
        game.doAction(controller2, Action.EXECUTE);
        //shoot
        game.doAction(controller2, Action.EXECUTE);

        assertEquals(player, game.getPlayer());

        //move
        game.doAction(controller, Action.EXECUTE);
        //aim
        game.doAction(controller, Action.EXECUTE);
        //shoot
        game.doAction(controller, Action.EXECUTE);

        assertEquals(player2, game.getPlayer());

        //move
        game.doAction(controller, Action.EXECUTE);
        //aim
        game.doAction(controller, Action.EXECUTE);
        //shoot
        game.doAction(controller, Action.EXECUTE);

        assertEquals(player2, game.getPlayer());

        //move
        game.doAction(controller2, Action.EXECUTE);
        //aim
        game.doAction(controller2, Action.EXECUTE);
        //shoot
        game.doAction(controller2, Action.EXECUTE);

        assertEquals(player, game.getPlayer());

    }

    @Test
    public void removePlayer() {
        Configuration configuration = getConfiguration();
        Game game = new Game(configuration);
        Controller controller = new Controller("slot1");
        Player player = new Player("player1", game);
        Player player2 = new Player("player2", game);
        Player player3 = new Player("player3", game);
        game.addPlayer(player, controller);
        game.addPlayer(player2, controller);
        game.addPlayer(player3, controller);

        game.start();

        assertEquals(player, game.getPlayer());
        //move
        game.doAction(controller, Action.EXECUTE);
        //aim
        game.doAction(controller, Action.EXECUTE);

        game.removePlayer(player2);

        //shoot
        game.doAction(controller, Action.EXECUTE);

        assertEquals(player3, game.getPlayer());

    }
}