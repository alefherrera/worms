package model.equipment;

import model.DamageReceiver;
import model.DamageSource;
import model.units.Power;
import model.units.Size;

public class Bullet implements DamageSource {

    private final Size size;
    private final Double weight;
    private final Power power;

    public Bullet(Size size, Double weight, Power power) {
        this.size = size;
        this.weight = weight;
        this.power = power;
    }

    public Double getWeight() {
        return weight;
    }

    public Power getPower() {
        return power;
    }

    public Size getSize() {
        return size;
    }

    public void damage(DamageReceiver receiver) {
        receiver.onDamageReceive(this, getPower());
    }

}
