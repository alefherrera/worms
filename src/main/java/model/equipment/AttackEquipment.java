package model.equipment;

import java.util.Optional;

public class AttackEquipment extends Equipment<Weapon> {

    public Optional<Bullet> shot() {
        Optional<Weapon> optionalWeapon = getItems().stream().findFirst();
        if (optionalWeapon.isPresent()) {
            Weapon weapon = optionalWeapon.get();
            if (weapon.getAmmo() > 0) {
                return Optional.of(weapon.getBullet());
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

}
