package worms.model.behaviors;

import worms.model.units.Power;

public interface Powerable {

    int DELTA = 5;

    Power getPower();
    void setPower(Power power);

    default Power increase() {
        final Power power = getPower().increase(DELTA);
        setPower(power);
        return power;
    }

    default Power decrease() {
        final Power power = getPower().decrease(DELTA);
        setPower(power);
        return power;
    }

}
