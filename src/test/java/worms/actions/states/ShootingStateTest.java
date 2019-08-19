package worms.actions.states;

import org.junit.Test;
import worms.actions.character.LeftAngleAction;
import worms.actions.character.LeftPowerAction;
import worms.actions.character.RightAngleAction;
import worms.actions.character.RightPowerAction;
import worms.actions.controller.ActivateAction;
import worms.actions.controller.CancelAction;
import worms.actions.controller.ExecuteAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;
import worms.actions.player.ChangeStateAction;
import worms.actions.player.CharacterPlayerAction;
import worms.actions.player.EmptyPlayerAction;
import worms.actions.player.PlayerAction;

import static org.junit.Assert.*;

public class ShootingStateTest {

    @Test
    public void whenActivateActionThenEmpty() {
        final PlayerState state = new ShootingState();
        final PlayerAction action = state.getAction(new ActivateAction());
        final PlayerAction expected = new EmptyPlayerAction();
        assertEquals(expected, action);
    }

    @Test
    public void whenExecuteActionThenChangeToWaitingState() {
        final PlayerState state = new ShootingState();
        final PlayerAction action = state.getAction(new ExecuteAction());
        final PlayerAction expected = new ChangeStateAction(new WaitingState());
        assertEquals(expected, action);
    }

    @Test
    public void whenCancelActionThenChangeToAimingState() {
        final PlayerState state = new ShootingState();
        final PlayerAction action = state.getAction(new CancelAction());
        final PlayerAction expected = new ChangeStateAction(new AimingState());
        assertEquals(expected, action);
    }

    @Test
    public void whenRightControllerActionThenRightPower() {
        final PlayerState state = new ShootingState();
        final PlayerAction action = state.getAction(new RightControllerAction());
        final PlayerAction expected = new CharacterPlayerAction(new RightPowerAction());
        assertEquals(expected, action);
    }

    @Test
    public void whenLeftControllerActionThenLeftPower() {
        final PlayerState state = new ShootingState();
        final PlayerAction action = state.getAction(new LeftControllerAction());
        final PlayerAction expected = new CharacterPlayerAction(new LeftPowerAction());
        assertEquals(expected, action);
    }

}