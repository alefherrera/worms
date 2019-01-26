package model.states;

import model.Player;
import model.actions.Action;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class PlayerState {

    transient final Map<Action, Function<Player, PlayerState>> conditions = new HashMap<>();

    public PlayerState onAction(Action action, Player player) {
        return conditions.getOrDefault(action, this::defaultCase).apply(player);
    }

    public static PlayerState getDefaultState() {
        return new WaitingPlayerState();
    }

    private PlayerState defaultCase(Player player) {
        return this;
    }
}
