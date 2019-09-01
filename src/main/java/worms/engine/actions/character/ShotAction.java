package worms.engine.actions.character;

import worms.model.Character;

public class ShotAction extends AbstractCharacterAction {
    @Override
    public void execute(final Character character) {
        character.shot();
    }

    @Override
    public String toString() {
        return "ShotAction{}";
    }
}
