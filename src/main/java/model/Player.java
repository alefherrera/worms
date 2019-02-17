package model;

import model.actions.Action;
import model.elements.Character;
import model.elements.MovingBullet;
import model.equipment.*;
import model.stat.Stat;
import model.stat.StatContainer;
import model.states.PlayerState;
import physic.PhysicCreator;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class Player implements ControllerListener, DamageReceiver {

    private final Character character;
    private final String name;
    private final StatContainer statContainer;
    private transient final Match match;
    private PlayerState state;
    private final AttackEquipment attackEquipment;
    private final DefenseEquipment defenseEquipment;
    private final PhysicCreator physicCreator;

    public Player(String name, Match match) {
        this.match = match;
        physicCreator = new PhysicCreator();
        this.name = name;
        this.character = new Character(Position.DEFAULT);
        this.state = PlayerState.getDefault(this);
        attackEquipment = new AttackEquipment();
        defenseEquipment = new DefenseEquipment();
        Map<StatType, Stat> stats = new HashMap<>();
        stats.put(StatType.ANGLE, new Stat(0D, 0D, 360D, value -> match.getConfiguration().getConfig(StatType.ANGLE)));
        stats.put(StatType.HEALTH, new Stat(100D, 0D, 100D, Function.identity()));
        stats.put(StatType.POWER, new Stat(0D, 0D, 100D, value -> match.getConfiguration().getConfig(StatType.POWER)));
        statContainer = new StatContainer(stats);
        match.addElement(character);
    }

    public void moveRight() {
        changePosition(match.getConfiguration().getConfig(StatType.SPEED));
    }

    public void moveLeft() {
        changePosition(-match.getConfiguration().getConfig(StatType.SPEED));
    }

    private void changePosition(double howMuch) {
        Position position = this.character.getPosition();
        this.character.setPosition(new Position(position.getX() + howMuch, position.getY()));
    }

    public void addWeapon(Weapon weapon) {
        attackEquipment.add(weapon);
    }

    public void addShield(Shield shield) {
        defenseEquipment.add(shield);
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

    Position getPosition() {
        return this.character.getPosition();
    }

    public void shot() {
        Optional<Bullet> optionalBullet = attackEquipment.shot();
        Double angle = getAngle();
        Double power = getPower();
        LocalTime time = LocalTime.now();
        if (!optionalBullet.isPresent()) {
            return;
        }
        Function<LocalTime, Position> function = physicCreator.createFunction(power, angle, character.getPosition(), time);
        Bullet concreteBullet = optionalBullet.get();
        MovingBullet movingBullet = new MovingBullet(concreteBullet, function);
        match.addElement(movingBullet);
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
