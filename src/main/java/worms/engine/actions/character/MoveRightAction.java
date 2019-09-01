package worms.engine.actions.character;

import worms.model.Character;

public class MoveRightAction extends AbstractCharacterAction {

    @Override
    public void execute(final Character character) {
        character.moveRight();
    }

    @Override
    public String toString() {
        return "MoveRightAction{}";
    }
}
