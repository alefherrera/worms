package model;

import model.config.Configuration;
import service.TurnManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Match implements PlayerListener {

    private transient final Game game;
    private transient final Configuration configuration;
    private transient final Function<List<Player>, TurnManager> turnManagerSupplier;
    private TurnManager turnManager;
    private final List<Player> players;

    Match(Game game, Configuration configuration, Function<List<Player>, TurnManager> turnManagerSupplier) {
        this.game = game;
        this.configuration = configuration;
        this.turnManagerSupplier = turnManagerSupplier;
        players = new ArrayList<>();
    }

    public Player addPlayer(String name, Controller controller) {
        Player player = new Player(name, this);
        players.add(player);
        controller.addListener(player);
        controller.addListener(game);
        return player;
    }

    void removePlayer(String name) {
        List<Player> collect = players.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            players.remove(collect.get(0));
        }
    }

    public void start() {
        turnManager = turnManagerSupplier.apply(players);
    }

    public Player getPlayer() {
        return turnManager.getCurrent();
    }

    public void onShot() {
        turnManager.next();
    }

    Configuration getConfiguration() {
        return configuration;
    }
}
