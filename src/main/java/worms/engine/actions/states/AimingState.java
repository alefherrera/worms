package worms.engine.actions.states;

import worms.engine.actions.character.LeftAngleAction;
import worms.engine.actions.character.RightAngleAction;
import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.player.CharacterPlayerAction;
import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.controller.GameAction;
import worms.engine.actions.controller.RightControllerAction;

public class AimingState extends PlayerState {

    @Override
    public PlayerAction getAction(final GameAction gameAction) {
        return gameAction.getAction(this);
    }

    @Override
    public PlayerAction getAction(final RightControllerAction action) {
        return new CharacterPlayerAction(new RightAngleAction());
    }

    @Override
    public PlayerAction getAction(final LeftControllerAction action) {
        return new CharacterPlayerAction(new LeftAngleAction());
    }

    @Override
    public PlayerAction getAction(final ExecuteAction action) {
        return new ChangeStateAction(new ShootingState());
    }

    @Override
    public PlayerAction getAction(final CancelAction action) {
        return new ChangeStateAction(new MovingState());
    }
}
