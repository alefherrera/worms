package worms.model;

import worms.model.behaviors.Aimeable;
import worms.model.behaviors.Healthy;
import worms.model.behaviors.Measurable;
import worms.model.behaviors.Movable;
import worms.model.behaviors.Powerable;
import worms.model.behaviors.Shooter;
import worms.model.units.Aim;
import worms.model.units.Health;
import worms.model.units.Position;
import worms.model.units.Power;
import worms.model.units.Size;

import java.util.ArrayList;
import java.util.List;

public class Character implements Healthy, Measurable, Movable, Aimeable, Powerable, Shooter {

    private static final int INITIAL_HEALTH = 100;
    private final List<CharacterObserver> observers;
    private final Size size;
    private Power power;
    private Health health;
    private Position position;
    private Aim aim;

    public Character(final Size size, final Position position) {
        this.size = size;
        this.position = position;
        observers = new ArrayList<>();
        health = new Health(INITIAL_HEALTH);
        aim = new Aim(0);
        power = new Power(0);
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
        update();
    }

    @Override
    public Aim getAim() {
        return aim;
    }

    @Override
    public void setAim(final Aim aim) {
        this.aim = aim;
        update();
    }

    @Override
    public Power getPower() {
        return power;
    }

    @Override
    public void setPower(final Power power) {
        this.power = power;
        update();
    }

    private void update() {
        observers.forEach(characterObserver -> {
            characterObserver.update();
        });
    }

}
