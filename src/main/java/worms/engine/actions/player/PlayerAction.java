package worms.engine.actions.player;

import worms.engine.Player;

@FunctionalInterface
public interface PlayerAction {

    void execute(Player player);

}
