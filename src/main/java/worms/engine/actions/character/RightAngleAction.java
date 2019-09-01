package worms.engine.actions.character;

import worms.model.Character;

public class RightAngleAction extends AbstractCharacterAction {
    @Override
    public Character execute(final Character character) {
        character.increaseAngle();
        return character;
    }

    @Override
    public String toString() {
        return "RightAngleAction{}";
    }
}
