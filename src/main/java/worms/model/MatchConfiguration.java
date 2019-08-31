package worms.model;

public class MatchConfiguration {

    private final int maxTurns;

    public MatchConfiguration(int maxTurns) {
        this.maxTurns = maxTurns;
    }

    public int getMaxTurns() {
        return maxTurns;
    }
}
