package model.elements;

import model.Power;

public class Bullet extends Element {

    private final Double weight;
    private final Power power;

    public Bullet(Double weight, Power power) {
        this.weight = weight;
        this.power = power;
    }

    public Double getWeight() {
        return weight;
    }

    public Power getPower() {
        return power;
    }
}
