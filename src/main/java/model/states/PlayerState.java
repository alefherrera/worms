package model.states;

import model.Player;
import model.actions.Action;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class PlayerState {

    private final String id;
    protected transient final Player player;

    PlayerState(String id, Player player) {
        this.player = player;
        this.id = id;
    }

    transient final Map<Action, Supplier<PlayerState>> conditions = new HashMap<>();

    public PlayerState onAction(Action action) {
        return conditions.getOrDefault(action, this::defaultCase).get();
    }

    public static PlayerState getDefault(Player player) {
        return new WaitingPlayerState(player);
    }

    private PlayerState defaultCase() {
        return this;
    }

}
