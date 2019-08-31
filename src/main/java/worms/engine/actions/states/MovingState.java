package worms.engine.actions.states;

import worms.engine.actions.character.MoveLeftAction;
import worms.engine.actions.character.MoveRightAction;
import worms.engine.actions.DeactivateAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.GameAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.player.CharacterPlayerAction;
import worms.engine.actions.player.PlayerAction;

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

    @Override
    public PlayerAction getAction(final DeactivateAction action) {
        return new ChangeStateAction(new WaitingState());
    }
}
