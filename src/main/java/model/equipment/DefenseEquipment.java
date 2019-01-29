package model.equipment;

import model.DamageSource;
import model.Power;

public class DefenseEquipment extends Equipment<Shield> {

    public Power tryBlock(DamageSource source, Power power) {
        getItems().forEach(shield -> shield.block(source, power));
        return power;
    }
}
