package worms.engine.actions.character;

import worms.model.Character;

public class RightAngleAction extends AbstractCharacterAction {
    @Override
    public void execute(final Character character) {
        character.increaseAngle();
    }

    @Override
    public String toString() {
        return "RightAngleAction{}";
    }
}
