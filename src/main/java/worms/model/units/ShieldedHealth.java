package worms.model.units;

public class ShieldedHealth extends Health {

    private Shield shield;

    public ShieldedHealth(final Health health, final Shield shield) {
        super(health.getValue());
        this.shield = shield;
    }

    @Override
    public Health damage(final Integer value) {
        shield = shield.damage(value);
        if (shield.getValue() <= 0) {
            return super.damage(-shield.getValue());
        } else {
            return this;
        }
    }

    @Override
    public Health restore(final Integer value) {
        return this;
    }

    @Override
    public Health addShield(final Shield shield) {
        this.shield = shield;
        return this;
    }

    @Override
    public Integer getValue() {
        return shield.getValue() + super.getValue();
    }
}
