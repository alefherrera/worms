package model.equipment;

import java.util.ArrayList;
import java.util.List;

public class Equipment {

    private final List<Weapon> weapons;
    private final List<Shield> shields;
    private Weapon currentWeapon;

    public Equipment() {
        weapons = new ArrayList<>();
        shields = new ArrayList<>();
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Shield> getShields() {
        return shields;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }
}
