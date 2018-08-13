package model;

import service.TurnManagerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<ActivePlayer> players;
    private final Configuration configuration;
    private final TurnManagerService turnManagerService;

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

    private ActivePlayer getCurrentPlayer() {
        return this.players.get(turnManagerService.getCurrentPlayer());
    }

    public void start() {
        getCurrentPlayer().onAction(Action.ACTIVATE);
    }

    public void onAction(Action action) {
        getCurrentPlayer().onAction(action);
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
