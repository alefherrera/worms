package worms.actions.character;

import worms.Character;
import worms.actions.player.PlayerAction;

public class MoveRightAction implements CharacterAction {

    @Override
    public void execute(final Character character) {
        character.moveRight();
    }
}
