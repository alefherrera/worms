package worms.actions.states;

import worms.actions.character.MoveLeftAction;
import worms.actions.character.MoveRightAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;
import worms.actions.player.CharacterPlayerAction;
import worms.actions.player.PlayerAction;

public class MovingState extends PlayerState {

    @Override
    public PlayerAction getAction(final GameAction gameAction) {
        return gameAction.execute(this);
    }

    @Override
    public PlayerAction execute(final RightControllerAction action) {
        return new CharacterPlayerAction(new MoveRightAction());
    }

    @Override
    public PlayerAction execute(final LeftControllerAction action) {
        return new CharacterPlayerAction(new MoveLeftAction());
    }
}
