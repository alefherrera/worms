package worms.engine.actions.player;

import worms.model.Player;

@FunctionalInterface
public interface PlayerAction {

    void execute(Player player);

}
