package worms.engine.actions.aim;

import org.junit.Test;
import worms.model.behaviors.Aimeable;
import worms.model.units.Aim;
import worms.model.units.Health;

import static org.junit.Assert.*;

public class DecreaseAngleActionTest {

    @Test
    public void test() {
        final DecreaseAngleAction action = new DecreaseAngleAction();
        final Aimeable target = new Aimeable() {

            private Aim aim = new Aim(0);

            @Override
            public Aim getAim() {
                return aim;
            }

            @Override
            public void setAim(final Aim aim) {
                this.aim = aim;
            }
        };
        final Aimeable result = action.execute(target);
        assertEquals(new Aim(-5), result.getAim());
    }

}