package model.elements;

import model.Position;
import model.Power;
import model.Size;

public class Bullet extends Element {

    private final Double weight;
    private final Power power;

    public Bullet(Size size, Double weight, Power power) {
        super(size, Position.DEFAULT);
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
