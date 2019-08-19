package worms.actions.states;

import worms.actions.character.LeftPowerAction;
import worms.actions.character.RightPowerAction;
import worms.actions.controller.CancelAction;
import worms.actions.controller.ExecuteAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.player.ChangeStateAction;
import worms.actions.player.CharacterPlayerAction;
import worms.actions.player.PlayerAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.RightControllerAction;

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
