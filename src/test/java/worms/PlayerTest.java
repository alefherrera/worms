package worms;

import org.junit.Test;
import worms.actiions.MoveLeftAction;
import worms.actiions.MoveRightAction;

import static org.junit.Assert.assertTrue;

public class PlayerTest {

    @Test
    public void moveRight() {
        Player player = new Player();
        Character character = player.getCharacter();
        Position oldPosition = character.getPosition();
        player.execute(new MoveRightAction());
        Position newPosition = character.getPosition();
        int i = newPosition.getX().compareTo(oldPosition.getX());
        assertTrue(i > 0);
    }

    @Test
    public void moveLeft() {
        Player player = new Player();
        Character character = player.getCharacter();
        Position oldPosition = character.getPosition();
        player.execute(new MoveLeftAction());
        Position newPosition = character.getPosition();
        int i = newPosition.getX().compareTo(oldPosition.getX());
        assertTrue(i < 0);
    }

}