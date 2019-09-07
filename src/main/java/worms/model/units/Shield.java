package worms.model.units;

public class Shield {

    private final Integer value;

    public Shield(final Integer value) {
        this.value = value;
    }

    public Shield damage(final Integer value) {
        return new Shield(this.value - value);
    }

    public Integer getValue() {
        return value;
    }
}
