package service;

import model.PlayerListener;

public class TurnManagerService implements PlayerListener  {

    private Long turns;
    private Integer numberOfPlayers;
    private Integer currentPlayer;

    public TurnManagerService() {
        currentPlayer = 0;
        numberOfPlayers = 0;
        turns = 0l;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    private void next() {
        if (currentPlayer == numberOfPlayers) {
            currentPlayer = 0;
            turns++;
        } else {
            currentPlayer++;
        }
    }

    public Long getTurns() {
        return turns;
    }

    public Integer getCurrentPlayer() {
        return currentPlayer;
    }

    public void onShot() {
        next();
    }
}
