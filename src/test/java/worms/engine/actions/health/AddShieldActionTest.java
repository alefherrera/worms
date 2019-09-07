package worms.engine.actions.health;

import org.junit.Test;
import worms.model.units.Shield;
import worms.model.behaviors.Healthy;
import worms.model.units.Health;

import static org.junit.Assert.assertEquals;

public class AddShieldActionTest {

    @Test
    public void test() {
        final AddShieldAction action = new AddShieldAction(new Shield(10));
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
        assertEquals(Integer.valueOf(110), result.getHealth().getValue());
    }

}