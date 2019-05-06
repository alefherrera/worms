package model.equipment;

import model.DamageSource;
import model.units.Power;

public interface Shield {

    Power block(DamageSource source, Power power);

    boolean isBroken();

}
