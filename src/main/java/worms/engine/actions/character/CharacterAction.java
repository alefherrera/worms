package worms.engine.actions.character;

import worms.model.Character;

@FunctionalInterface
public interface CharacterAction {

    void execute(Character character);

}
