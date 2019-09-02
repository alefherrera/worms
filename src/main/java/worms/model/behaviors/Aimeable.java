package worms.model.behaviors;

import worms.model.units.Aim;

public interface Aimeable {

    int DELTA = 5;

    Aim getAim();

    void setAim(Aim aim);

    default Aim decreaseAngle() {
        final Aim aim = getAim().decrease(DELTA);
        setAim(aim);
        return aim;
    }

    default Aim increaseAngle() {
        final Aim aim = getAim().increase(DELTA);
        setAim(aim);
        return aim;
    }
}
