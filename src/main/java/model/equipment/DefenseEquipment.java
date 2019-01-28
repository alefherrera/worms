package model.equipment;

import model.DamageSource;
import model.Power;

public class DefenseEquipment extends Equipment<Shield> {

    public Power tryBlock(DamageSource source, Power power) {
        return new Power(0D);
    }
}
