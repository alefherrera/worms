package worms.engine.actions.shot;

import org.junit.Test;
import worms.model.Weapon;
import worms.model.behaviors.Shooter;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SelectPreviousWeaponActionTest {

    @Test
    public void test() {
        final SelectPreviousWeaponAction action = new SelectPreviousWeaponAction();
        final Shooter target = getTarget(1);
        final Shooter result = action.execute(target);
        assertEquals(new Weapon("weapon1"), result.getWeapon());
    }

    @Test
    public void testCycle() {
        final SelectPreviousWeaponAction action = new SelectPreviousWeaponAction();
        final Shooter target = getTarget(0);
        final Shooter result = action.execute(target);
        assertEquals(new Weapon("weapon3"), result.getWeapon());
    }

    public Shooter getTarget(Integer defaultWeapon) {
        return new Shooter() {

            private List<Weapon> weapons = Arrays.asList(
                    new Weapon("weapon1"),
                    new Weapon("weapon2"),
                    new Weapon("weapon3")
            );

            private Weapon weapon = weapons.get(defaultWeapon);

            @Override
            public void shot() {

            }

            @Override
            public List<Weapon> getWeapons() {
                return weapons;
            }

            @Override
            public void setWeapon(final Weapon weapon) {
                this.weapon = weapon;
            }

            @Override
            public Weapon getWeapon() {
                return weapon;
            }
        };
    }

}