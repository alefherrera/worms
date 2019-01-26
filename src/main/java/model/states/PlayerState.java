package model.states;

import model.actions.Action;
import model.elements.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class PlayerState {

    protected final Map<Action, Function<Player, PlayerState>> map = new HashMap<>();

    public PlayerState onAction(Action action, Player player) {
        return map.getOrDefault(action, this::defaultCase).apply(player);
    }

    private PlayerState defaultCase(Player player) {
        return this;
    }

}
