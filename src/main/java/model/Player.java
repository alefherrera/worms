package model;

import enums.MovementDirection;

import java.util.ArrayList;
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

    public Player(Game game) {
        game.addPlayer(this);
        configuration = game.getConfiguration();
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
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

    public void shot() {
        this.currentWeapon.shot();
    }

    public void receiveDamage(Double howMuch) {
        this.health -= howMuch;
    }

}
