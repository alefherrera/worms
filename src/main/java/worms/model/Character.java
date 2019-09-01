package worms.model;

import worms.engine.actions.Action;
import worms.engine.actions.character.CharacterAction;
import worms.engine.actions.movement.MoveLeftAction;
import worms.model.units.Health;
import worms.model.units.Position;
import worms.model.units.Size;

import java.util.ArrayList;
import java.util.List;

public class Character implements Healthy, Measurable, Movable {

    private static final int DELTA = 5;
    public static final int INITIAL_HEALTH = 100;
    private final List<CharacterObserver> observers;
    private Health health;
    private final Size size;
    private Position position;
    private Integer angle;

    public Character(final Size size, final Position position) {
        this.size = size;
        this.position = position;
        angle = 0;
        observers = new ArrayList<>();
        health = new Health(INITIAL_HEALTH);
    }

    public void increaseAngle() {
        angle += DELTA;
        updateAngle();
    }

    public void decreaseAngle() {
        angle -= DELTA;
        updateAngle();
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

    public void shot() {

    }

    @Override
    public Health getHealth() {
        return health;
    }

    @Override
    public void setHealth(final Health health) {
        this.health = health;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(final Position position) {
        this.position = position;
        updatePosition();
    }

}
