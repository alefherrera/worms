package worms.model.units;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShieldedHealthTest {

    @Test
    public void testBreakShield() {
        final ShieldedHealth shieldedHealth = new ShieldedHealth(new Health(100), new Shield(10));
        final Health result = shieldedHealth.damage(20);
        assertEquals(Integer.valueOf(90), result.getValue());
    }

    @Test
    public void testDamageShield() {
        final ShieldedHealth shieldedHealth = new ShieldedHealth(new Health(100), new Shield(10));
        final Health result = shieldedHealth.damage(5);
        assertEquals(Integer.valueOf(115), result.getValue());
    }

}