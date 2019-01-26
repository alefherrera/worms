package model;

import model.actions.Action;
import model.config.Configuration;
import model.elements.Character;
import model.equipment.Equipment;
import model.equipment.Weapon;
import model.stat.Stat;
import model.stat.StatContainer;
import model.states.PlayerState;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;

public class Player implements ControllerListener {

    private final Character character;
    private final String name;
    private transient final Controller controller;
    private final StatContainer statContainer;
    private transient PlayerState state;
    private transient final Collection<PlayerListener> listeners;
    private final Equipment equipment;
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
        Map<StatType, Stat> stats = new HashMap<>();
        stats.put(StatType.ANGLE, new Stat(0D, 0D, 360D, value -> configuration.getAimingSpeed()));
        stats.put(StatType.HEALTH, new Stat(0D, 0D, 360D, Function.identity()));
        stats.put(StatType.POWER, new Stat(0D, 0D, 360D, value -> configuration.getPowerSpeed()));
        statContainer = new StatContainer(stats);
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
        return statContainer.getValue(StatType.HEALTH).orElse(null);
    }

    public Double getAngle() {
        return statContainer.getValue(StatType.ANGLE).orElse(null);
    }

    public Double getPower() {
        return statContainer.getValue(StatType.POWER).orElse(null);
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

    public void increase(StatType statType, Double value) {
        statContainer.increase(statType, value);
    }

    public void decrease(StatType statType, Double value) {
        statContainer.decrease(statType, value);
    }

    public void increase(StatType statType) {
        increase(statType, null);
    }

    public void decrease(StatType statType) {
        decrease(statType, null);
    }

    public String getName() {
        return name;
    }

    public void onAction(Action action) {
        this.state = this.state.onAction(action, this);
    }
}
