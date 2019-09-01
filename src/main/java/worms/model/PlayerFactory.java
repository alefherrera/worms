package worms.model;

import worms.model.units.Position;

@FunctionalInterface
public interface PlayerFactory {

    Player create(String name, Position position);

}
