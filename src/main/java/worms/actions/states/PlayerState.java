package worms.actions.states;

import worms.actions.controller.ActivateAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;
import worms.actions.player.EmptyPlayerAction;
import worms.actions.player.PlayerAction;

import java.util.Objects;

public abstract class PlayerState {

    public abstract PlayerAction getAction(final GameAction gameAction);

    public PlayerAction execute(final RightControllerAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction execute(final ActivateAction action) {
        return new EmptyPlayerAction();
    }

    public PlayerAction execute(final LeftControllerAction action) {
        return new EmptyPlayerAction();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlayerState)) {
            return false;
        }
        final PlayerState that = (PlayerState) o;
        return Objects.equals(getClass(), that.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
