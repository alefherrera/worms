package worms.actions.character;

import worms.Character;
import worms.actions.states.CharacterState;

public class ChangeStateAction implements CharacterAction {

    private final CharacterState characterState;

    public ChangeStateAction(CharacterState characterState) {
        this.characterState = characterState;
    }

    @Override
    public void execute(final Character character) {
        character.setState(characterState);
    }
}
