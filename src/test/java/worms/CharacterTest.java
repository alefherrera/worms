package worms;

import org.junit.Test;
import worms.actions.character.MoveLeftAction;
import worms.actions.character.MoveRightAction;

import static org.junit.Assert.assertTrue;

public class CharacterTest {

    @Test
    public void moveRight() {
        final Character character = new Character(new Position(0, 0));
        final Position oldPosition = character.getPosition();
        character.execute(new MoveRightAction());
        final Position newPosition = character.getPosition();
        int i = newPosition.getX().compareTo(oldPosition.getX());
        assertTrue("New position isnt grater than the old", i > 0);
    }

    @Test
    public void moveLeft() {
        final Character character = new Character(new Position(0, 0));
        final Position oldPosition = character.getPosition();
        character.execute(new MoveLeftAction());
        final Position newPosition = character.getPosition();
        int i = newPosition.getX().compareTo(oldPosition.getX());
        assertTrue("New position is grater than the old", i < 0);
    }

}