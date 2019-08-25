package worms.engine;

@FunctionalInterface
public interface PlayerFactory {

    Player create(String name, Position position);

}
