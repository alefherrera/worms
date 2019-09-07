package worms.model;

import worms.engine.actions.Action;
import worms.engine.actions.controller.ControllerAction;
import worms.engine.actions.controller.GameAction;
import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.states.PlayerState;

import java.util.ArrayList;
import java.util.List;

public class Player implements ControllerListener {

    private final String name;
    private Character character;
    private PlayerState playerState;
    private final List<PlayerObserver> observers;

    public Player(final String name, final Character character, final PlayerState playerState) {
        this.name = name;
        this.character = character;
        this.playerState = playerState;
        observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Character getCharacter() {
        return character;
    }

    public ActionExecutionResult execute(final GameAction gameAction) {
        final PlayerAction playerAction = playerState.getAction(gameAction);
        execute(playerAction);
        return new ActionExecutionResult(playerAction, Result.OK);
    }

    public void setPlayerState(final PlayerState playerState) {
        this.playerState = playerState;
        observers.forEach(playerObserver -> {
            playerObserver.update(playerState);
        });
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void execute(final PlayerAction playerAction) {
        playerAction.execute(this);
    }

    public void add(PlayerObserver observer) {
        observers.add(observer);
    }

    public void remove(PlayerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void onControllerAction(final ControllerAction action) {
        execute(action);
    }

    public void execute(final Action<Character> action) {
        character = action.execute(character);
    }
}
