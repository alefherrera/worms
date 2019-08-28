package worms.engine;

import worms.model.Player;

@FunctionalInterface
public interface PlayerFactory {

    Player create(String name, Position position);

}
