package model.config;

public class Configuration {

    private Double movingSpeed;
    private Double aimingSpeed;
    private Double powerSpeed;
    private Double initialHealth;

    public Double getMovingSpeed() {
        return movingSpeed;
    }

    public void setMovingSpeed(Double movingSpeed) {
        this.movingSpeed = movingSpeed;
    }

    public Double getAimingSpeed() {
        return aimingSpeed;
    }

    public void setAimingSpeed(Double aimingSpeed) {
        this.aimingSpeed = aimingSpeed;
    }

    public Double getPowerSpeed() {
        return powerSpeed;
    }

    public void setPowerSpeed(Double powerSpeed) {
        this.powerSpeed = powerSpeed;
    }

    public Double getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(Double initialHealth) {
        this.initialHealth = initialHealth;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "movingSpeed=" + movingSpeed +
                ", aimingSpeed=" + aimingSpeed +
                ", powerSpeed=" + powerSpeed +
                ", initialHealth=" + initialHealth +
                '}';
    }
}
