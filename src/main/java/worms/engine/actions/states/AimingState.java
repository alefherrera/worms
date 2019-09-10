package worms.engine.actions.states;

import worms.engine.actions.aim.DecreaseAngleAction;
import worms.engine.actions.aim.IncreaseAngleAction;
import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.DeactivateAction;
import worms.engine.actions.controller.DownControllerAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.UpControllerAction;
import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.player.CharacterPlayerAction;
import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.controller.GameAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.engine.actions.shot.SelectNextWeaponAction;
import worms.engine.actions.shot.SelectPreviousWeaponAction;

public class AimingState extends PlayerState {

    @Override
    public PlayerAction getAction(final GameAction gameAction) {
        return gameAction.getAction(this);
    }

    @Override
    public PlayerAction getAction(final RightControllerAction action) {
        return new CharacterPlayerAction(new IncreaseAngleAction());
    }

    @Override
    public PlayerAction getAction(final LeftControllerAction action) {
        return new CharacterPlayerAction(new DecreaseAngleAction());
    }

    @Override
    public PlayerAction getAction(final UpControllerAction action) {
        return new CharacterPlayerAction(new SelectNextWeaponAction());
    }

    @Override
    public PlayerAction getAction(final DownControllerAction action) {
        return new CharacterPlayerAction(new SelectPreviousWeaponAction());
    }

    @Override
    public PlayerAction getAction(final DeactivateAction action) {
        return new ChangeStateAction(new IdleState());
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
