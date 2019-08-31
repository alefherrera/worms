package worms.model;

public interface CharacterObserver {
    void update(Position position);

    void update(Integer angle);
}
