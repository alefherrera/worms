package worms.engine.actions.character;

import worms.engine.Character;

@FunctionalInterface
public interface CharacterAction {

    void execute(Character character);

}
