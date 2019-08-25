package worms.engine;

import worms.engine.actions.character.CharacterAction;

public abstract class Character {

    private Position position;
    private Size size;
    private final static int DELTA = 1;

    public Character(final Position position, final Size size) {
        this.position = position;
        this.size = size;
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
