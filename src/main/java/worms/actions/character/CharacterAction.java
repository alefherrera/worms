package worms.actions.character;

import worms.Character;

@FunctionalInterface
public interface CharacterAction {

    void execute(Character player);

}
