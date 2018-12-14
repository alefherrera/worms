package model.equipment;

import model.elements.Bullet;

public class Weapon {

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
}
