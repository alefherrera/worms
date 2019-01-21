package model;

import model.config.Configuration;
import model.elements.Player;
import service.TurnManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Match implements PlayerListener {

    private final Configuration configuration;
    private final Function<List<ActivePlayer>, TurnManager> turnManagerSupplier;
    private TurnManager turnManager;
    private final List<ActivePlayer> players;

    public Match(Configuration configuration, Function<List<ActivePlayer>, TurnManager> turnManagerSupplier) {
        this.configuration = configuration;
        this.turnManagerSupplier = turnManagerSupplier;
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
        turnManager = turnManagerSupplier.apply(players);
    }

    public Player getPlayer() {
        return turnManager.getCurrent().getPlayer();
    }

    @Override
    public void onShot() {
        turnManager.next();
    }

    @Override
    public String toString() {
        return "Match{" +
                "configuration=" + configuration +
                ", turnManager=" + turnManager +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Arrays.equals(players.toArray(), match.players.toArray());
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
