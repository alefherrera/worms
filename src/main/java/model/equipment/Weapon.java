package model.equipment;

import model.DamageReceiver;
import model.DamageSource;
import model.elements.Bullet;

public class Weapon implements DamageSource {

    private Double ammo;
    private Bullet bullet;

    public Weapon(Bullet bullet, Double ammo) {
        this.bullet = bullet;
        this.ammo = ammo;
    }

    public Double getAmmo() {
        return ammo;
    }

    public void addAmmo(Double howMuch) {
        ammo += howMuch;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void shot() {
        if (ammo > 0) {
            ammo -= 1;
        }
    }

    public void damage(DamageReceiver receiver) {
        receiver.onDamageReceive(this, bullet.getPower());
    }
}
