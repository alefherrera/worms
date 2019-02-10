package model.equipment;

import model.Power;
import model.Size;

public class Bullet {

    private final Size size;
    private final Double weight;
    private final Power power;

    public Bullet(Size size, Double weight, Power power) {
        this.size = size;
        this.weight = weight;
        this.power = power;
    }

    public Double getWeight() {
        return weight;
    }

    public Power getPower() {
        return power;
    }

    public Size getSize() {
        return size;
    }
}
