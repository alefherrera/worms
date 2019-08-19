package worms.actions.player;

import worms.Player;

public class EmptyPlayerAction implements PlayerAction {
    @Override
    public void execute(final Player player) {

    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        return getClass().equals(obj.getClass());
    }
}
