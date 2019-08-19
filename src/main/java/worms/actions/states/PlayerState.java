package worms.actions.states;

import worms.actions.controller.ActivateAction;
import worms.actions.controller.CancelAction;
import worms.actions.controller.ExecuteAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;
import worms.actions.player.EmptyPlayerAction;
import worms.actions.player.PlayerAction;

import java.util.Objects;

public abstract class PlayerState {

    public abstract PlayerAction getAction(final GameAction gameAction);

    public PlayerAction getAction(final RightControllerAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(final ActivateAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(final LeftControllerAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(final ExecuteAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(final CancelAction action) {
        return new EmptyPlayerAction();
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
}
