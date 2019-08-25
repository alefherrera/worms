package worms.engine.actions.states;

import worms.engine.actions.character.LeftPowerAction;
import worms.engine.actions.character.RightPowerAction;
import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.player.CharacterPlayerAction;
import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.controller.GameAction;
import worms.engine.actions.controller.RightControllerAction;

public class ShootingState extends PlayerState {

    @Override
    public PlayerAction getAction(final GameAction gameAction) {
        return gameAction.getAction(this);
    }

    @Override
    public PlayerAction getAction(final RightControllerAction action) {
        return new CharacterPlayerAction(new RightPowerAction());
    }

    @Override
    public PlayerAction getAction(final LeftControllerAction action) {
        return new CharacterPlayerAction(new LeftPowerAction());
    }

    @Override
    public PlayerAction getAction(final ExecuteAction action) {
        return new ChangeStateAction(new WaitingState());
    }

    @Override
    public PlayerAction getAction(final CancelAction action) {
        return new ChangeStateAction(new AimingState());
    }
}
