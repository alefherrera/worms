package worms;

public class Game {

    private GameStatus gameStatus;

    public Game() {
        gameStatus = new GameStatus();
    }

    public Match createMatch(final MatchConfiguration configuration) {
        return new Match(configuration);
    }

    public GameStatus getStatus() {
        return gameStatus;
    }

    public void start() {
        gameStatus.setRunning(true);
    }

    public void exit() {
        gameStatus.setRunning(false);
    }
}
