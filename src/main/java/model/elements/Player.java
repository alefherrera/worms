package model.elements;

import enums.MovementDirection;
import model.*;
import model.config.Configuration;
import model.equipment.Shield;
import model.equipment.Weapon;
import model.states.PlayerState;

import java.util.*;

public class Player extends Element {

    private final String name;
    private final Configuration configuration;
    private Double health;
    private Double angle;
    private Double power;
    private List<Weapon> weapons;
    private List<Shield> shields;
    private Weapon currentWeapon;
    private final Collection<PlayerListener> listeners;

    public Player(String name, Configuration configuration) {
        this.name = name;
        this.configuration = configuration;
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
        this.listeners = new HashSet<>();
        this.angle = 0D;
        this.health = configuration.getInitialHealth();
        this.power = 0D;
        this.setPosition(new Position(0D, 0D));
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
        this.listeners.forEach(PlayerListener::onShot);
    }

    public void receiveDamage(Double howMuch) {
        this.health -= howMuch;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(health, player.health) &&
                Objects.equals(angle, player.angle) &&
                Objects.equals(power, player.power) &&
                Objects.equals(weapons, player.weapons) &&
                Objects.equals(shields, player.shields) &&
                Objects.equals(currentWeapon, player.currentWeapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, angle, power, weapons, shields, currentWeapon);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
