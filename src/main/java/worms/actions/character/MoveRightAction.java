package worms.actions.character;

import worms.Character;

public class MoveRightAction implements CharacterAction {

    @Override
    public void execute(final Character character) {
        character.moveRight();
    }
}
