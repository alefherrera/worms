package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void onAction() {
        Double movingSpeed = 10d;
        Double aimingSpeed = 2d;
        Double powerSpeed = 1d;
        Double zero = Double.valueOf(0d);
        Configuration configuration = new Configuration();
        configuration.setMovingSpeed(movingSpeed);
        configuration.setAimingSpeed(aimingSpeed);
        configuration.setPowerSpeed(powerSpeed);
        Game game = new Game(configuration);
        Player player = new Player(game);
        game.start();
        game.onAction(Action.RIGHT);

        assertEquals(movingSpeed, player.getPosition().getX());

        game.onAction(Action.LEFT);

        assertEquals(zero, player.getPosition().getX());

        game.onAction(Action.EXECUTE);

        game.onAction(Action.RIGHT);

        assertEquals(zero, player.getPosition().getX());

        assertEquals(aimingSpeed, player.getAngle());

        game.onAction(Action.EXECUTE);

        game.onAction(Action.RIGHT);

        assertEquals(powerSpeed, player.getPower());

    }
}