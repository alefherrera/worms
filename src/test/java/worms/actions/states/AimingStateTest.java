package worms.actions.states;

import org.junit.Test;
import worms.actions.character.LeftAngleAction;
import worms.actions.character.RightAngleAction;
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

public class AimingStateTest {

    @Test
    public void whenActivateActionThenEmpty() {
        final PlayerState state = new AimingState();
        final PlayerAction action = state.getAction(new ActivateAction());
        final PlayerAction expected = new EmptyPlayerAction();
        assertEquals(expected, action);
    }

    @Test
    public void whenExecuteActionThenChangeToShootingState() {
        final PlayerState state = new AimingState();
        final PlayerAction action = state.getAction(new ExecuteAction());
        final PlayerAction expected = new ChangeStateAction(new ShootingState());
        assertEquals(expected, action);
    }

    @Test
    public void whenCancelActionThenChangeToMovingState() {
        final PlayerState state = new AimingState();
        final PlayerAction action = state.getAction(new CancelAction());
        final PlayerAction expected = new ChangeStateAction(new MovingState());
        assertEquals(expected, action);
    }

    @Test
    public void whenRightControllerActionThenRightAngle() {
        final PlayerState state = new AimingState();
        final PlayerAction action = state.getAction(new RightControllerAction());
        final PlayerAction expected = new CharacterPlayerAction(new RightAngleAction());
        assertEquals(expected, action);
    }

    @Test
    public void whenLeftControllerActionThenLeftAngle() {
        final PlayerState state = new AimingState();
        final PlayerAction action = state.getAction(new LeftControllerAction());
        final PlayerAction expected = new CharacterPlayerAction(new LeftAngleAction());
        assertEquals(expected, action);
    }

}