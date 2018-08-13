package model;

import enums.MovementDirection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Player extends Element {

    private final Configuration configuration;
    private Double health;
    private PlayerState state;
    private Double angle;
    private Double power;
    private List<Weapon> weapons;
    private List<Shield> shields;
    private Weapon currentWeapon;
    private Collection<PlayerListener> listeners;

    public Player(Game game) {
        configuration = game.getConfiguration();
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
        this.listeners = new HashSet<>();
        this.angle = 0d;
        this.health = 0d;
        this.power = 0d;
        this.setPosition(new Position(0d, 0d));
        game.addPlayer(this);
    }

    public void addListener(PlayerListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(PlayerListener listener) {
        this.listeners.remove(listener);
    }

    public void move(MovementDirection direction) {
        if (direction.equals(MovementDirection.RIGHT)) {
            changePosition(configuration.getMovingSpeed());
        } else {
            changePosition(-configuration.getMovingSpeed());
        }
    }

    private void changePosition(double howMuch) {
        Position position = this.getPosition();
        this.setPosition(new Position(position.getX() + howMuch, position.getY()));
    }

    public void increaseAngle() {
        angle = Math.min(180, angle + configuration.getAimingSpeed());
    }

    public void decreaseAngle() {
        angle = Math.max(0, angle - configuration.getAimingSpeed());
    }

    public void increasePower() {
        power = Math.min(100, power + configuration.getPowerSpeed());
    }

    public void decreasePower() {
        power = Math.max(0, power - configuration.getPowerSpeed());
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public Double getHealth() {
        return health;
    }

    public Double getAngle() {
        return angle;
    }

    public Double getPower() {
        return power;
    }

    public void shot() {
        if (this.currentWeapon != null) {
            this.currentWeapon.shot();
        }
        this.listeners.forEach(x -> x.onShot());
    }

    public void receiveDamage(Double howMuch) {
        this.health -= howMuch;
    }

}
