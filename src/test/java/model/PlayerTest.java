package model;

import model.equipment.Bullet;
import model.equipment.Weapon;
import model.units.Power;
import model.units.Size;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class PlayerTest {

    @Test
    public void onDamageReceive() {
        Match match = mock(Match.class);
        Player player = new Player("player1", match);
        Weapon weapon = new Weapon(new Bullet(new Size(2D, 2D),100D, new Power(10D)), 2D);
        weapon.damage(player);
        Double health = player.getHealth();
        Assert.assertEquals(Double.valueOf(90D), health);
    }
}