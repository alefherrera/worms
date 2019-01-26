package model.stat;

import java.util.function.Function;

public class Stat {

    private Double value;
    private final Double min;
    private final Double max;
    protected final Function<Double, Double> modifier;

    public Stat(Double value, Double min, Double max, Function<Double, Double> modifier) {
        this.value = value;
        this.min = min;
        this.max = max;
        this.modifier = modifier;
    }

    protected void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void increase(Double value) {
        double newValue = this.value + modifier.apply(value);
        if (newValue < max) {
            setValue(newValue);
        }
    }

    public void decrease(Double value) {
        double newValue = this.value - modifier.apply(value);
        if (newValue > min) {
            setValue(newValue);
        }
    }

}
