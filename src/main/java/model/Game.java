package model;

import enums.Action;
import model.config.Configuration;
import model.elements.Player;
import model.states.WaitingPlayerState;
import service.TurnManagerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<ActivePlayer> players;
    private final Configuration configuration;
    private final TurnManagerService turnManagerService;

    Game(Configuration configuration) {
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

    public Player getPlayer() {
        return getCurrentPlayer().getPlayer();
    }

    void start() {
        getCurrentPlayer().onAction(Action.ACTIVATE);
    }

    void onAction(Action action) {
        getCurrentPlayer().onAction(action);
    }

    void removePlayer(Player player) {
        List<ActivePlayer> playerList = players.stream().filter(x -> x.getPlayer().equals(player)).collect(Collectors.toList());
        if (!playerList.isEmpty()) {
            ActivePlayer playerToRemove = playerList.get(0);
            playerToRemove.getPlayer().removeListener(turnManagerService);
            players.remove(playerToRemove);
        }
        updateTurnManager();
    }

    private ActivePlayer getCurrentPlayer() {
        return this.players.get(turnManagerService.getCurrentPlayer());
    }

    private void updateTurnManager() {
        turnManagerService.setNumberOfPlayers(players.size());
    }
}
