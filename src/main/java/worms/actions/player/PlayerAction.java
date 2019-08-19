package worms.actions.player;

import worms.Player;

@FunctionalInterface
public interface PlayerAction {

    void execute(Player player);

}
