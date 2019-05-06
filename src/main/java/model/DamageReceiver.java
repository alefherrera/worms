package model;

import model.units.Power;

public interface DamageReceiver {

    void onDamageReceive(DamageSource source, Power power);

}
