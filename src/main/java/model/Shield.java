package model;

public class Shield {

    private Double radio;
    private Double durability;

    public Shield(Double radio, Double durability) {
        this.radio = radio;
        this.durability = durability;
    }

    public void receiveDamage(Double howMuch) {
        this.durability -= howMuch;
    }
}
