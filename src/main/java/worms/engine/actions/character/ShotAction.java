package worms.engine.actions.character;

import worms.model.Character;

public class ShotAction extends AbstractCharacterAction {
    @Override
    public Character execute(final Character character) {
        character.shot();
        return character;
    }

    @Override
    public String toString() {
        return "ShotAction{}";
    }
}
