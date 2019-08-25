package worms.engine;

@FunctionalInterface
public interface CharacterFactory {

    Character create(String name, Position position, Size size);
}
