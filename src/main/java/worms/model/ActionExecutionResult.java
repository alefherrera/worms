package worms.model;

import worms.engine.actions.player.PlayerAction;

public class ActionExecutionResult {

    private final PlayerAction playerAction;
    private final Result result;

    public ActionExecutionResult(final PlayerAction playerAction, final Result result) {
        this.playerAction = playerAction;
        this.result = result;
    }

    public PlayerAction getPlayerAction() {
        return playerAction;
    }

    public Result getResult() {
        return result;
    }
}
