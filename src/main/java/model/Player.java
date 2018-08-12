package model;

import enums.MovementDirection;
import enums.PlayerState;

import java.util.Collection;
import java.util.HashSet;

public class Player extends Element {

    private final Game game;
    private Double health;
    private PlayerState state;
    private Collection<Weapon> weapons;
    private Collection<Shield> shields;

    public Player(Game game) {
        this.game = game;
        this.state = PlayerState.MOVING;
        this.weapons = new HashSet<>();
        this.shields = new HashSet<>();
    }

    public void move(MovementDirection direction) {
        if (direction.equals(MovementDirection.LEFT)) {
            changePosition(game.getSpeed());
        } else {
            changePosition(game.getSpeed() * -1);
        }
    }

    private void changePosition(double howMuch) {
        Position position = this.getPosition();
        position.setX(position.getX() + howMuch);
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void aim() {
        this.state = PlayerState.AIMING;
    }

    public void shoot() {
        this.state = PlayerState.MOVING;
    }

    public void receiveDamage(Double howMuch) {
        this.health -= howMuch;
    }

}
