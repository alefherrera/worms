package worms.engine.actions.character;

import worms.model.Character;

public class LeftAngleAction extends AbstractCharacterAction {
    @Override
    public void execute(final Character character) {
        character.decreaseAngle();
    }

    @Override
    public String toString() {
        return "LeftAngleAction{}";
    }
}
