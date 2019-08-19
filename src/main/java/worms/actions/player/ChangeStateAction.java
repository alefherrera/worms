package worms.actions.player;

import worms.Player;
import worms.actions.states.PlayerState;

import java.util.Objects;

public class ChangeStateAction implements PlayerAction {

    private final PlayerState playerState;

    public ChangeStateAction(PlayerState playerState) {
        this.playerState = playerState;
    }

    @Override
    public void execute(final Player player) {
        player.setPlayerState(playerState);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChangeStateAction)) {
            return false;
        }
        final ChangeStateAction that = (ChangeStateAction) o;
        return Objects.equals(playerState, that.playerState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerState);
    }
}
