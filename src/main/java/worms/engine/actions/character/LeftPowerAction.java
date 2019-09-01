package worms.engine.actions.character;

import worms.model.Character;

public class LeftPowerAction extends AbstractCharacterAction {
    @Override
    public Character execute(final Character character) {
        return character;
    }

    @Override
    public String toString() {
        return "LeftPowerAction{}";
    }
}
