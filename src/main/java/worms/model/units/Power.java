package worms.model.units;

import java.util.Objects;

public class Power {

    private final Integer value;

    public Power(final Integer value) {
        this.value = value;
    }

    public Power increase(final Integer value) {
        return new Power(this.value + value);
    }

    public Power decrease(final Integer value) {
        return new Power(this.value - value);
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Power)) {
            return false;
        }
        final Power power = (Power) o;
        return Objects.equals(value, power.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
