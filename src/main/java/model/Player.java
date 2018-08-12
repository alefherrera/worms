package model;

import enums.MovementDirection;
import enums.PlayerState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Player extends Element {

    private final Game game;
    private Double health;
    private Stance stance;
    private Double angle;
    private Double power;
    private List<Weapon> weapons;
    private List<Shield> shields;
    private Weapon currentWeapon;

    public Player(Game game) {
        this.game = game;
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
        this.stance = new MovingStance();
    }

    public void move(MovementDirection direction) {
        if (direction.equals(MovementDirection.RIGHT)) {
            changePosition(game.getMovingSpeed());
        } else {
            changePosition(-game.getMovingSpeed());
        }
    }

    private void changePosition(double howMuch) {
        Position position = this.getPosition();
        this.setPosition(new Position(position.getX() + howMuch, position.getY()));
    }

    public void increaseAngle() {
        angle = Math.min(180, angle + game.getAimingSpeed());
    }

    public void decreaseAngle() {
        angle = Math.max(0, angle - game.getAimingSpeed());
    }

    public void increasePower() {
        power = Math.min(100, power + game.getPowerSpeed());
    }

    public void decreasePower() {
        power = Math.max(0, power - game.getPowerSpeed());
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void shot() {
        this.currentWeapon.shot();
    }

    public void onAction(Action action) {
        this.stance = this.stance.onAction(action, this);
    }

    public void receiveDamage(Double howMuch) {
        this.health -= howMuch;
    }

}
