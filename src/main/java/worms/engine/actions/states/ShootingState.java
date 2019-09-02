package worms.engine.actions.states;

import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.DeactivateAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.player.CharacterPlayerAction;
import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.controller.GameAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.engine.actions.power.DecreasePowerAction;
import worms.engine.actions.power.IncreasePowerAction;
import worms.engine.actions.shot.ShotAction;

public class ShootingState extends PlayerState {

    @Override
    public PlayerAction getAction(final GameAction gameAction) {
        return gameAction.getAction(this);
    }

    @Override
    public PlayerAction getAction(final RightControllerAction action) {
        return new CharacterPlayerAction(new IncreasePowerAction());
    }

    @Override
    public PlayerAction getAction(final LeftControllerAction action) {
        return new CharacterPlayerAction(new DecreasePowerAction());
    }

    @Override
    public PlayerAction getAction(final ExecuteAction action) {
        return new CharacterPlayerAction(new ShotAction());
    }

    @Override
    public PlayerAction getAction(final CancelAction action) {
        return new ChangeStateAction(new AimingState());
    }

    @Override
    public PlayerAction getAction(final DeactivateAction action) {
        return new ChangeStateAction(new IdleState());
    }
}
