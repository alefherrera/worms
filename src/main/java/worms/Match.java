package worms;

public class Match {

    private final MatchStatus matchStatus;

    public Match() {
        matchStatus = new MatchStatus();
    }

    public MatchStatus getStatus() {
        return matchStatus;
    }

    public void start() {
        matchStatus.setRunning(true);
    }

    public void stop() {
        matchStatus.setRunning(false);
    }
}
