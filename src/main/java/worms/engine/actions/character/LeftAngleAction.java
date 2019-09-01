package worms.engine.actions.character;

import worms.model.Character;

public class LeftAngleAction extends AbstractCharacterAction {
    @Override
    public Character execute(final Character character) {
        character.decreaseAngle();
        return character;
    }

    @Override
    public String toString() {
        return "LeftAngleAction{}";
    }
}
