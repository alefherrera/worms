package worms.model;

import worms.engine.Position;

public interface CharacterObserver {
    void update(Position position);

    void update(Integer angle);
}
