package model;

import model.actions.ExecuteAction;
import model.actions.LeftAction;
import model.actions.RightAction;
import model.config.Configuration;
import org.junit.Test;
import service.SecuencialTurnManager;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private static final Double MOVING_SPEED = 10d;
    private static final Double AIMING_SPEED = 2d;
    private static final Double POWER_SPEED = 1d;
    private static final Double ZERO = 0d;

    private static Configuration getConfiguration() {
        Configuration.ConfigurationBuilder builder = new Configuration.ConfigurationBuilder();
        builder.addSetting(StatType.ANGLE, AIMING_SPEED)
                .addSetting(StatType.POWER, POWER_SPEED)
                .addSetting(StatType.SPEED, MOVING_SPEED);
        return builder.build();
    }

    @Test
    public void onAction() {
        Configuration configuration = getConfiguration();
        Game game = new Game(new Looper(1000, new StatusSpy()));
        BattleGround battleGround = new BattleGround(new Size(2D, 2D));
        Match match = game.createMatch(configuration, battleGround, SecuencialTurnManager::new);
        Controller controller = new Controller("slot1");
        Player player = match.addPlayer("player1", controller);

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
        BattleGround battleGround = new BattleGround(new Size(2D, 2D));
        Match match = game.createMatch(configuration, battleGround, SecuencialTurnManager::new);
        Controller controller = new Controller("slot1");
        Controller controller2 = new Controller("slot2");
        Player player = match.addPlayer("player1", controller);
        Player player2 = match.addPlayer("player2", controller2);

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
        BattleGround battleGround = new BattleGround(new Size(2D, 2D));
        Match match = game.createMatch(configuration, battleGround, SecuencialTurnManager::new);
        Controller controller = new Controller("slot1");
        Player player1 = match.addPlayer("player1", controller);
        match.addPlayer("player2", controller);
        Player player3 = match.addPlayer("player3", controller);

        game.start();
        match.start();

        assertEquals(player1, match.getPlayer());
        //move
        controller.sendAction(new ExecuteAction());
        //aim
        controller.sendAction(new ExecuteAction());

        match.removePlayer("player2");

        //shoot
        controller.sendAction(new ExecuteAction());

        assertEquals(player3, match.getPlayer());

    }
}