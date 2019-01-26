package model;

import model.config.Configuration;
import model.elements.Player;
import service.TurnManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Match implements PlayerListener {

    private transient final Game game;
    private transient final Configuration configuration;
    private transient final Function<List<ActivePlayer>, TurnManager> turnManagerSupplier;
    private TurnManager turnManager;
    private final List<ActivePlayer> players;

    Match(Game game, Configuration configuration, Function<List<ActivePlayer>, TurnManager> turnManagerSupplier) {
        this.game = game;
        this.configuration = configuration;
        this.turnManagerSupplier = turnManagerSupplier;
        players = new ArrayList<>();
    }

    public void addPlayer(Player player, Controller controller) {
        players.add(new ActivePlayer(controller, player));
        player.addListener(this);
        controller.addListener(game);
    }

    void removePlayer(Player player) {
        List<ActivePlayer> collect = players.stream().filter(x -> x.getPlayer().equals(player)).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            players.remove(collect.get(0));
        }
    }

    public void start() {
        turnManager = turnManagerSupplier.apply(players);
    }

    public Player getPlayer() {
        return turnManager.getCurrent().getPlayer();
    }

    @Override
    public void onShot() {
        turnManager.next();
    }
}
