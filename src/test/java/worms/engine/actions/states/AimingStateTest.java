package worms.engine.actions.states;

import org.junit.Test;
import worms.engine.actions.aim.DecreaseAngleAction;
import worms.engine.actions.aim.IncreaseAngleAction;
import worms.engine.actions.ActivateAction;
import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.player.CharacterPlayerAction;
import worms.engine.actions.player.EmptyPlayerAction;
import worms.engine.actions.player.PlayerAction;

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
        final PlayerAction expected = new CharacterPlayerAction(new IncreaseAngleAction());
        assertEquals(expected, action);
    }

    @Test
    public void whenLeftControllerActionThenLeftAngle() {
        final PlayerState state = new AimingState();
        final PlayerAction action = state.getAction(new LeftControllerAction());
        final PlayerAction expected = new CharacterPlayerAction(new DecreaseAngleAction());
        assertEquals(expected, action);
    }

}