package worms.engine.actions.shot;

import org.junit.Test;
import worms.engine.actions.aim.DecreaseAngleAction;
import worms.model.Weapon;
import worms.model.behaviors.Aimeable;
import worms.model.behaviors.Shooter;
import worms.model.units.Aim;

import java.util.List;

import static org.junit.Assert.*;

public class ShotActionTest {

    @Test
    public void test() {
        final ShotAction action = new ShotAction();
        final Shooter target = new Shooter() {
            @Override
            public void shot() {

            }

            @Override
            public List<Weapon> getWeapons() {
                return null;
            }

            @Override
            public void setWeapon(final Weapon weapon) {

            }

            @Override
            public Weapon getWeapon() {
                return null;
            }
        };
        final Shooter result = action.execute(target);
    }

}