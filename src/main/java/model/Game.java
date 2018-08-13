package model;

import service.TurnManagerService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<ActivePlayer> players;
    private final Configuration configuration;
    private final TurnManagerService turnManagerService;
    private Integer currentPlayer;
    private boolean started;

    public Game(Configuration configuration) {
        this.configuration = configuration;
        this.players = new ArrayList<>();
        turnManagerService = new TurnManagerService();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void addPlayer(Player player) {
        player.addListener(turnManagerService);
        players.add(new ActivePlayer(player, new WaitingPlayerState()));
        updateTurnManager();
    }

    public void onAction(Action action) {
        this.players.get(turnManagerService.getCurrentPlayer()).onAction(action);
    }

    public void removePlayer(Player player) {
        List<ActivePlayer> playerList = players.stream().filter(x -> x.getPlayer().equals(player)).collect(Collectors.toList());
        if (playerList.isEmpty()) {
            ActivePlayer playerToRemove = playerList.get(0);
            playerToRemove.getPlayer().removeListener(turnManagerService);
            players.remove(playerToRemove);
        }
        updateTurnManager();
    }

    private void updateTurnManager() {
        turnManagerService.setNumberOfPlayers(players.size());
    }
}
