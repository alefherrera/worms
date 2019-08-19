package worms.actions.states;

import worms.actions.character.CharacterAction;
import worms.actions.character.EmptyAction;
import worms.actions.controller.ActivateAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;

import java.util.Objects;

public abstract class CharacterState {

    public abstract CharacterAction getAction(final GameAction gameAction);

    public CharacterAction execute(final RightControllerAction action) {
        return new EmptyAction();
    }

    public CharacterAction execute(final ActivateAction action) {
        return new EmptyAction();
    }

    public CharacterAction execute(final LeftControllerAction action) {
        return new EmptyAction();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CharacterState)) {
            return false;
        }
        final CharacterState that = (CharacterState) o;
        return Objects.equals(getClass(), that.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
