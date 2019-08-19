package worms;

import worms.actions.character.CharacterAction;
import worms.actions.controller.GameAction;
import worms.actions.states.CharacterState;

public class Character {

    private Position position;
    private final static int DELTA = 1;
    private CharacterState characterState;

    public Character(Position position, CharacterState characterState) {
        this.position = position;
        this.characterState = characterState;
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

    public void setState(final CharacterState characterState) {
        this.characterState = characterState;
    }

    public CharacterState getCharacterState() {
        return characterState;
    }

    public void execute(final GameAction gameAction) {
        final CharacterAction characterAction = characterState.getAction(gameAction);
        execute(characterAction);
    }
}
