package worms.engine.actions.health;

import org.junit.Test;
import worms.model.behaviors.Healthy;
import worms.model.units.Health;

import static org.junit.Assert.assertEquals;

public class HealActionTest {

    @Test
    public void test() {
        final HealAction action = new HealAction(10);
        final Healthy target = new Healthy() {

            private Health health = new Health(100);

            @Override
            public Health getHealth() {
                return health;
            }

            @Override
            public void setHealth(final Health health) {
                this.health = health;
            }
        };
        final Healthy result = action.execute(target);
        assertEquals(result.getHealth(), new Health(110));
    }

}