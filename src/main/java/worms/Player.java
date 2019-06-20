package worms;

import worms.actiions.CharacterAction;

public class Player {

    private final Character character;

    public Player() {
        character = new Character(new Position(0, 0));
    }

    public void execute(final CharacterAction action) {
        action.execute(character);
    }

    public Character getCharacter() {
        return character;
    }
}
