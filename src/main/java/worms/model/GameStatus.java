package worms.model;

public class GameStatus {

    public Boolean getRunning() {
        return isRunning;
    }

    public void setRunning(final Boolean running) {
        isRunning = running;
    }

    private Boolean isRunning = false;

}
