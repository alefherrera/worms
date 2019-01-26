package model.stat;

import model.StatType;

import java.util.Map;
import java.util.Optional;

public class StatContainer {

    private Map<StatType, Stat> stats;

    public StatContainer(Map<StatType, Stat> stats) {
        this.stats = stats;
    }

    public void increase(StatType statType, Double value) {
        if (stats.containsKey(statType)) {
            stats.get(statType).increase(value);
        }
    }

    public void decrease(StatType statType, Double value) {
        if (stats.containsKey(statType)) {
            stats.get(statType).decrease(value);
        }
    }

    public Optional<Double> getValue(StatType statType) {
        if (stats.containsKey(statType)) {
            Double value = stats.get(statType).getValue();
            return Optional.of(value);
        } else {
            return Optional.empty();
        }
    }
}
