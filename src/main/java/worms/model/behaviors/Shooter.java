package worms.model.behaviors;

import worms.model.Weapon;

import java.util.List;

public interface Shooter {

    void shot();

    List<Weapon> getWeapons();

    void setWeapon(Weapon weapon);

    Weapon getWeapon();

    default Weapon setNextWeapon() {
        final List<Weapon> weapons = getWeapons();
        final int i = weapons.indexOf(getWeapon());
        if (i >= weapons.size() - 1) {
            return setWeaponFromIndex(0);
        }
        return setWeaponFromIndex(i + 1);
    }

    default Weapon setPreviousWeapon() {
        final List<Weapon> weapons = getWeapons();
        final int i = weapons.indexOf(getWeapon());
        if (i <= 0) {
            return setWeaponFromIndex(weapons.size() - 1);
        }
        return setWeaponFromIndex(i - 1);
    }

    default Weapon setWeaponFromIndex(int index) {
        final Weapon weapon = getWeapons().get(index);
        setWeapon(weapon);
        return weapon;
    }

    default void addWeapon(Weapon weapon) {
        getWeapons().add(weapon);
    }

}
