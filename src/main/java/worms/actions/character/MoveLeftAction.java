package worms.actions.character;

import worms.Character;
import worms.actions.player.PlayerAction;
import worms.actions.states.PlayerState;

import java.util.Objects;

public class MoveLeftAction implements CharacterAction {
    @Override
    public void execute(final Character character) {
        character.moveLeft();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        return Objects.equals(getClass(), o.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

    @Override
    public String toString() {
        return "MoveLeftAction{}";
    }
}
