package worms.actiions;

import worms.Character;

@FunctionalInterface
public interface CharacterAction {

    void execute(Character character);

}
