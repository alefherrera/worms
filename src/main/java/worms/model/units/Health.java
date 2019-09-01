package worms.model.units;

import java.util.Objects;

public class Health {

    private final Integer value;

    public Health(Integer value) {
        this.value = value;
    }

    public Health damage(final Integer value) {
        return new Health(this.value - value);
    }

    public Health restore(final Integer value) {
        return new Health(this.value + value);
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Health)) {
            return false;
        }
        final Health health = (Health) o;
        return Objects.equals(value, health.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
