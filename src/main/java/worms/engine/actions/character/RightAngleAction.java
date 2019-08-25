package worms.engine.actions.character;

import worms.engine.Character;

import java.util.Objects;

public class RightAngleAction implements CharacterAction {
    @Override
    public void execute(final Character player) {

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
        return "RightAngleAction{}";
    }
}
