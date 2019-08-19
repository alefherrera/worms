package worms.actions.states;

import worms.actions.character.MoveLeftAction;
import worms.actions.character.MoveRightAction;
import worms.actions.controller.ExecuteAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;
import worms.actions.player.ChangeStateAction;
import worms.actions.player.CharacterPlayerAction;
import worms.actions.player.PlayerAction;

public class MovingState extends PlayerState {

    @Override
    public PlayerAction getAction(final GameAction gameAction) {
        return gameAction.getAction(this);
    }

    @Override
    public PlayerAction getAction(final RightControllerAction action) {
        return new CharacterPlayerAction(new MoveRightAction());
    }

    @Override
    public PlayerAction getAction(final LeftControllerAction action) {
        return new CharacterPlayerAction(new MoveLeftAction());
    }

    @Override
    public PlayerAction getAction(final ExecuteAction action) {
        return new ChangeStateAction(new AimingState());
    }
}
