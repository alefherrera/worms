package model;

import model.actions.Action;
import model.config.Configuration;
import model.elements.Character;
import model.equipment.AttackEquipment;
import model.equipment.DefenseEquipment;
import model.equipment.Shield;
import model.equipment.Weapon;
import model.stat.Stat;
import model.stat.StatContainer;
import model.states.PlayerState;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;

public class Player implements ControllerListener, DamageReceiver {

    private final Character character;
    private final String name;
    private final StatContainer statContainer;
    private PlayerState state;
    private transient final Collection<PlayerListener> listeners;
    private final AttackEquipment attackEquipment;
    private final DefenseEquipment defenseEquipment;
    private final Configuration configuration;

    public Player(String name, Match match) {
        this.name = name;
        this.listeners = new HashSet<>();
        this.character = new Character();
        this.state = PlayerState.getDefault(this);
        attackEquipment = new AttackEquipment();
        defenseEquipment = new DefenseEquipment();
        configuration = match.getConfiguration();
        Map<StatType, Stat> stats = new HashMap<>();
        stats.put(StatType.ANGLE, new Stat(0D, 0D, 360D, value -> configuration.getConfig(StatType.ANGLE)));
        stats.put(StatType.HEALTH, new Stat(100D, 0D, 100D, Function.identity()));
        stats.put(StatType.POWER, new Stat(0D, 0D, 100D, value -> configuration.getConfig(StatType.POWER)));
        statContainer = new StatContainer(stats);
        this.listeners.add(match);
    }

    public void moveRight() {
        changePosition(configuration.getConfig(StatType.SPEED));
    }

    public void moveLeft() {
        changePosition(-configuration.getConfig(StatType.SPEED));
    }

    private void changePosition(double howMuch) {
        Position position = this.character.getPosition();
        this.character.setPosition(new Position(position.getX() + howMuch, position.getY()));
    }

    public void addWeapon(Weapon weapon) {
        attackEquipment.add(weapon);
    }

    public void addShield(Shield shield) { defenseEquipment.add(shield); }

    public Double getHealth() {
        return statContainer.getValue(StatType.HEALTH).orElse(null);
    }

    Double getAngle() {
        return statContainer.getValue(StatType.ANGLE).orElse(null);
    }

    Double getPower() {
        return statContainer.getValue(StatType.POWER).orElse(null);
    }

    Position getPosition() {
        return this.character.getPosition();
    }

    public void shot() {
        attackEquipment.shot();
        this.listeners.forEach(PlayerListener::onShot);
    }

    private void increase(StatType statType, Double value) {
        statContainer.increase(statType, value);
    }

    private void decrease(StatType statType, Double value) {
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
        this.state = this.state.onAction(action);
    }

    public void onDamageReceive(DamageSource source, Power power) {
        Power resultPower = defenseEquipment.tryBlock(source, power);
        decrease(StatType.HEALTH, resultPower.getValue());
    }
}
