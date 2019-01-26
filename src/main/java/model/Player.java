package model;

import model.actions.Action;
import model.config.Configuration;
import model.elements.Character;
import model.equipment.Equipment;
import model.equipment.Weapon;
import model.stat.Stat;
import model.states.PlayerState;

import java.util.Collection;
import java.util.HashSet;

public class Player implements ControllerListener {

    private final Character character;
    private final String name;
    private transient final Controller controller;
    private transient PlayerState state;
    private transient final Collection<PlayerListener> listeners;
    private final Equipment equipment;
    private final Stat stat;
    private final Configuration configuration;

    public Player(Controller controller, String name, Match match) {
        this.name = name;
        this.controller = controller;
        controller.addListener(this);
        this.listeners = new HashSet<>();
        this.character = new Character();
        this.state = PlayerState.getDefaultState();
        equipment = new Equipment();
        configuration = match.getConfiguration();
        stat = new Stat();
        this.listeners.add(match);
    }

    public Character getCharacter() {
        return character;
    }

    public Controller getController() {
        return controller;
    }

    public void addListener(PlayerListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(PlayerListener listener) {
        this.listeners.remove(listener);
    }

    public void moveRight() {
        changePosition(configuration.getMovingSpeed());
    }

    public void moveLeft() {
        changePosition(-configuration.getMovingSpeed());
    }

    private void changePosition(double howMuch) {
        Position position = this.character.getPosition();
        this.character.setPosition(new Position(position.getX() + howMuch, position.getY()));
    }

    public void addWeapon(Weapon weapon) {
        equipment.getWeapons().add(weapon);
    }

    public Double getHealth() {
        return stat.getHealth();
    }

    public Double getAngle() {
        return stat.getAngle();
    }

    public Double getPower() {
        return stat.getPower();
    }

    public Position getPosition() {
        return this.character.getPosition();
    }

    public void shot() {
        if (equipment.getCurrentWeapon() != null) {
            equipment.getCurrentWeapon().shot();
        }
        this.listeners.forEach(PlayerListener::onShot);
    }

    public void receiveDamage(Double howMuch) {
        stat.setHealth(stat.getHealth() - howMuch);
    }

    public String getName() {
        return name;
    }


    public void onAction(Action action) {
        this.state = this.state.onAction(action, this);
    }

    public void decreaseAngle() {
        double newAngle = this.getAngle() - configuration.getAimingSpeed();
        this.stat.setAngle(newAngle);
    }

    public void increaseAngle() {
        double newAngle = this.getAngle() + configuration.getAimingSpeed();
        this.stat.setAngle(newAngle);
    }

    public void increasePower() {
        double newPower = this.stat.getPower() + configuration.getPowerSpeed();
        this.stat.setPower(newPower);
    }

    public void decreasePower() {
        double newPower = this.stat.getPower() - configuration.getPowerSpeed();
        this.stat.setPower(newPower);
    }
}
