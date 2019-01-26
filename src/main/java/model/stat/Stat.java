package model.stat;

public class Stat {

    private Double health;
    private Double angle;
    private Double power;

    public Stat() {
        health = 100D;
        angle = 0D;
        power = 0D;
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }
}
