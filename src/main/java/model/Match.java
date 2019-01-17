package model;

import model.config.Configuration;
import model.elements.Player;
import service.TurnManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Match implements PlayerListener {

    private final Configuration configuration;
    private final TurnManager turnManager;
    private final List<ActivePlayer> players;

    public Match(Configuration configuration, TurnManager turnManager) {
        this.configuration = configuration;
        this.turnManager = turnManager;
        players = new ArrayList<>();
    }

    public void addPlayer(Player player, Controller controller) {
        players.add(new ActivePlayer(controller, player));
        player.addListener(this);
    }

    public void removePlayer(Player player) {
        List<ActivePlayer> collect = players.stream().filter(x -> x.getPlayer().equals(player)).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            players.remove(collect.get(0));
        }
    }

    public void start() {
        turnManager.init(players);
    }

    public Player getPlayer() {
        return turnManager.getCurrent().getPlayer();
    }

    @Override
    public void onShot() {
        turnManager.next();
    }
}
