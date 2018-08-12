package model;

public class Bullet extends Element {

    private Double weight;
    private Double damage;

    public Bullet(Double weight, Double damage) {
        this.weight = weight;
        this.damage = damage;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getDamage() {
        return damage;
    }
}
