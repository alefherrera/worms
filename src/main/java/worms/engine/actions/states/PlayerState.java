package worms.engine.actions.states;

import worms.engine.actions.ActivateAction;
import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.DeactivateAction;
import worms.engine.actions.controller.DownControllerAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.GameAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.engine.actions.controller.UpControllerAction;
import worms.engine.actions.player.EmptyPlayerAction;
import worms.engine.actions.player.PlayerAction;

import java.util.Objects;

public abstract class PlayerState {

    public abstract PlayerAction getAction(final GameAction gameAction);

    public PlayerAction getAction(final RightControllerAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(final LeftControllerAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(final UpControllerAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(final DownControllerAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(final ActivateAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction getAction(final DeactivateAction action) {
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
