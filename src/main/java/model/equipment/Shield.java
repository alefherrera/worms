package model.equipment;

import model.DamageSource;
import model.Power;

public interface Shield {

    Power block(DamageSource source, Power power);

    boolean isBroken();

}
