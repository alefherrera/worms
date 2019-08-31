package worms.model;

@FunctionalInterface
public interface PlayerFactory {

    Player create(String name, Position position);

}
