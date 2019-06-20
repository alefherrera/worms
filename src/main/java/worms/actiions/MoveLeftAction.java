package worms.actiions;

import worms.Character;

public class MoveLeftAction implements CharacterAction {
    @Override
    public void execute(final Character character) {
        character.moveLeft();
    }
}
