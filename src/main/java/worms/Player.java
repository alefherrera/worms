package worms;

import worms.actions.character.CharacterAction;
import worms.actions.controller.GameAction;
import worms.actions.player.PlayerAction;
import worms.actions.states.PlayerState;

public class Player {

    private final String name;
    private final Character character;
    private PlayerState playerState;

    public Player(final String name, final Character character, final PlayerState playerState) {
        this.name = name;
        this.character = character;
        this.playerState = playerState;
    }

    public String getName() {
        return name;
    }

    public ActionExecutionResult execute(final GameAction gameAction) {
        final PlayerAction playerAction = playerState.getAction(gameAction);
        execute(playerAction);
        return new ActionExecutionResult(playerAction, Result.OK);
    }

    public void setPlayerState(final PlayerState playerState) {
        this.playerState = playerState;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void execute(final PlayerAction playerAction) {
        playerAction.execute(this);
    }

    public void execute(final CharacterAction characterAction) {
        character.execute(characterAction);
    }
}
