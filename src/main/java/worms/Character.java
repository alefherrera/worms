package worms;

import worms.actions.character.CharacterAction;

public class Character {

    private Position position;
    private final static int DELTA = 1;

    public Character(Position position) {
        this.position = position;
    }

    public void moveRight() {
        position = new Position(position.getX() + DELTA, position.getY());
    }

    public void moveLeft() {
        position = new Position(position.getX() - DELTA, position.getY());
    }

    public Position getPosition() {
        return position;
    }

    public void execute(final CharacterAction action) {
        action.execute(this);
    }
}
