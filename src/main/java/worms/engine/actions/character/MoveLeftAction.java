package worms.engine.actions.character;

import worms.model.Character;

public class MoveLeftAction extends AbstractCharacterAction {
    @Override
    public void execute(final Character character) {
        character.moveLeft();
    }

    @Override
    public String toString() {
        return "MoveLeftAction{}";
    }
}
