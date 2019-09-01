package worms.model;

import worms.engine.actions.Action;
import worms.model.units.Position;

public interface Movable {

    int DELTA = 5;

    Position getPosition();

    void setPosition(Position position);

    default Position moveRight() {
        final Position position = getPosition();
        final Position result = position.translateX(position.getX() + DELTA);
        setPosition(result);
        return result;
    }

    default Position moveLeft() {
        final Position position = getPosition();
        final Position result = position.translateX(position.getX() - DELTA);
        setPosition(result);
        return result;
    }

}
