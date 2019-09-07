package worms.engine.actions.health;

import org.junit.Test;
import worms.model.behaviors.Healthy;
import worms.model.units.Health;
import worms.model.units.Shield;
import worms.model.units.ShieldedHealth;

import static org.junit.Assert.assertEquals;

public class DamageActionTest {

    @Test
    public void test() {
        final DamageAction action = new DamageAction(10);
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
        assertEquals(new Health(90), result.getHealth());
    }

    @Test
    public void testWithShield() {
        final DamageAction action = new DamageAction(10);
        final Healthy target = new Healthy() {

            private Health health = new ShieldedHealth(new Health(100), new Shield(50));

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
        assertEquals(Integer.valueOf(140), result.getHealth().getValue());
    }

}