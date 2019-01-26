package model.config;

import model.StatType;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private final Map<StatType, Double> configs;

    private Configuration(Map<StatType, Double> configs) {
        this.configs = configs;
    }

    public Double getConfig(StatType statType) {
        return configs.getOrDefault(statType, null);
    }

    public static class ConfigurationBuilder {

        private final Map<StatType, Double> configs;

        public ConfigurationBuilder() {
            configs = new HashMap<>();
        }

        public ConfigurationBuilder addSetting(StatType statType, Double value) {
            configs.put(statType, value);
            return this;
        }

        public Configuration build() {
            return new Configuration(configs);
        }

    }

}
