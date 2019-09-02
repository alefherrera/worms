package worms.engine.actions.player;

import worms.engine.actions.Action;
import worms.model.Player;

import java.util.Objects;

public class CharacterPlayerAction implements PlayerAction {

    private final Action action;

    public CharacterPlayerAction(final Action action) {
        this.action = action;
    }

    @Override
    public void execute(final Player player) {
        player.execute(action);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CharacterPlayerAction)) {
            return false;
        }
        final CharacterPlayerAction that = (CharacterPlayerAction) o;
        return Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action);
    }
}
