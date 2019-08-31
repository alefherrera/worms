package worms.model;

import worms.engine.actions.character.CharacterAction;

import java.util.ArrayList;
import java.util.List;

public class Character extends Element {

    private static final int DELTA = 5;
    private final List<CharacterObserver> observers;
    private Position position;
    private Integer angle;

    public Character(final Size size, final Position position) {
        super(size);
        this.position = position;
        angle = 0;
        observers = new ArrayList<>();
    }

    public void moveRight() {
        position = position.moveRight(DELTA);
        updatePosition();
    }

    public void moveLeft() {
        position = position.moveLeft(DELTA);
        updatePosition();
    }

    public void increaseAngle() {
        angle += DELTA;
        updateAngle();
    }

    public void decreaseAngle() {
        angle -= DELTA;
        updateAngle();
    }

    public Position getPosition() {
        return position;
    }

    public Integer getAngle() {
        return angle;
    }

    private void updatePosition() {
        observers.forEach(characterObserver -> {
            characterObserver.update(position);
        });
    }

    private void updateAngle() {
        observers.forEach(characterObserver -> {
            characterObserver.update(angle);
        });
    }

    public void execute(final CharacterAction action) {
        action.execute(this);
    }

    public void add(CharacterObserver observer) {
        observers.add(observer);
    }

    public void remove(CharacterObserver observer) {
        observers.remove(observer);
    }
}
