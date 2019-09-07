package worms.engine.actions.power;

import org.junit.Test;
import worms.model.behaviors.Powerable;
import worms.model.units.Power;

import static org.junit.Assert.*;

public class IncreasePowerActionTest {

    @Test
    public void test() {
        final IncreasePowerAction action = new IncreasePowerAction();
        final Powerable target = new Powerable() {

            private Power power = new Power(0);

            @Override
            public Power getPower() {
                return power;
            }

            @Override
            public void setPower(final Power power) {
                this.power = power;
            }
        };
        final Powerable result = action.execute(target);
        assertEquals(new Power(5), result.getPower());
    }

}