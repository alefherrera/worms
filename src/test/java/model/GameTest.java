package model;

import model.actions.ExecuteAction;
import model.actions.LeftAction;
import model.actions.RightAction;
import model.config.Configuration;
import model.elements.Player;
import org.junit.Test;
import service.SecuencialTurnManager;

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
        Game game = new Game(new Looper(1000, new StatusSpy()));
        Match match = game.createMatch(configuration, SecuencialTurnManager::new);
        Controller controller = new Controller("slot1");
        Player player = new Player("player1", configuration);
        match.addPlayer(player, controller);

        game.start();
        match.start();

        controller.sendAction(new RightAction());

        assertEquals(MOVING_SPEED, player.getPosition().getX());

        controller.sendAction(new LeftAction());

        assertEquals(ZERO, player.getPosition().getX());

        controller.sendAction(new ExecuteAction());
        controller.sendAction(new RightAction());

        assertEquals(ZERO, player.getPosition().getX());

        assertEquals(AIMING_SPEED, player.getAngle());

        controller.sendAction(new ExecuteAction());
        controller.sendAction(new RightAction());

        assertEquals(POWER_SPEED, player.getPower());

    }

    @Test
    public void nextTurnPlayer() {
        Configuration configuration = getConfiguration();
        Game game = new Game(new Looper(1000, new StatusSpy()));
        Match match = game.createMatch(configuration, SecuencialTurnManager::new);
        Controller controller = new Controller("slot1");
        Controller controller2 = new Controller("slot2");
        Player player = new Player("player1", configuration);
        Player player2 = new Player("player2", configuration);
        match.addPlayer(player, controller);
        match.addPlayer(player2, controller2);

        game.start();
        match.start();

        assertEquals(player, match.getPlayer());

        //move
        controller2.sendAction(new ExecuteAction());
        //aim
        controller2.sendAction(new ExecuteAction());
        //shoot
        controller2.sendAction(new ExecuteAction());

        assertEquals(player, match.getPlayer());

        //move
        controller.sendAction(new ExecuteAction());
        //aim
        controller.sendAction(new ExecuteAction());
        //shoot
        controller.sendAction(new ExecuteAction());

        assertEquals(player2, match.getPlayer());

        //move
        controller.sendAction(new ExecuteAction());
        //aim
        controller.sendAction(new ExecuteAction());
        //shoot
        controller.sendAction(new ExecuteAction());

        assertEquals(player2, match.getPlayer());

        //move
        controller2.sendAction(new ExecuteAction());
        //aim
        controller2.sendAction(new ExecuteAction());
        //shoot
        controller2.sendAction(new ExecuteAction());

        assertEquals(player, match.getPlayer());

    }

    @Test
    public void removePlayer() {
        Configuration configuration = getConfiguration();
        Game game = new Game(new Looper(1000, new StatusSpy()));
        Match match = game.createMatch(configuration, SecuencialTurnManager::new);
        Controller controller = new Controller("slot1");
        Player player = new Player("player1", configuration);
        Player player2 = new Player("player2", configuration);
        Player player3 = new Player("player3", configuration);
        match.addPlayer(player, controller);
        match.addPlayer(player2, controller);
        match.addPlayer(player3, controller);

        game.start();
        match.start();

        assertEquals(player, match.getPlayer());
        //move
        controller.sendAction(new ExecuteAction());
        //aim
        controller.sendAction(new ExecuteAction());

        match.removePlayer(player2);

        //shoot
        controller.sendAction(new ExecuteAction());

        assertEquals(player3, match.getPlayer());

    }
}