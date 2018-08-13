package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final Collection<ActivePlayer> players;
    private final Configuration configuration;

    public Game(Configuration configuration) {
        this.configuration = configuration;
        this.players = new HashSet<>();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void addPlayer(Player player) {
        players.add(new ActivePlayer(player, new WaitingPlayerState()));
    }

    //public void onAction(Action action) {
    //    this.stance = this.stance.onAction(action, this);
    //}

    public void removePlayer(Player player) {
        List<ActivePlayer> playerList = players.stream().filter(x -> x.getPlayer().equals(player)).collect(Collectors.toList());
        if (playerList.isEmpty()) {
            players.remove(playerList.get(0));
        }
    }
}
