package worms.model.units;

import java.util.Objects;

public class Aim {

    private final Integer value;

    public Aim(Integer value) {
        this.value = value;
    }

    public Aim decrease(final Integer value) {
        return new Aim(this.value - value);
    }

    public Aim increase(final Integer value) {
        return new Aim(this.value + value);
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Aim)) {
            return false;
        }
        final Aim aim = (Aim) o;
        return Objects.equals(value, aim.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
