package worms.actions.states;

import org.junit.Test;
import worms.actions.controller.ActivateAction;
import worms.actions.controller.CancelAction;
import worms.actions.controller.ExecuteAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;
import worms.actions.player.ChangeStateAction;
import worms.actions.player.EmptyPlayerAction;
import worms.actions.player.PlayerAction;

import static org.junit.Assert.assertEquals;

public class WaitingStateTest {

    @Test
    public void whenActivateActionThenChangeToMovingState() {
        final PlayerState state = new WaitingState();
        final PlayerAction action = state.getAction(new ActivateAction());
        final PlayerAction expected = new ChangeStateAction(new MovingState());
        assertEquals(expected, action);
    }

    @Test
    public void whenExecuteActionThenEmpty() {
        final PlayerState state = new WaitingState();
        final PlayerAction action = state.getAction(new ExecuteAction());
        final PlayerAction expected = new EmptyPlayerAction();
        assertEquals(expected, action);
    }

    @Test
    public void whenCancelActionThenEmpty() {
        final PlayerState state = new WaitingState();
        final PlayerAction action = state.getAction(new CancelAction());
        final PlayerAction expected = new EmptyPlayerAction();
        assertEquals(expected, action);
    }

    @Test
    public void whenRightControllerActionThenEmpty() {
        final PlayerState state = new WaitingState();
        final PlayerAction action = state.getAction(new RightControllerAction());
        final PlayerAction expected = new EmptyPlayerAction();
        assertEquals(expected, action);
    }

    @Test
    public void whenLeftControllerActionThenEmpty() {
        final PlayerState state = new WaitingState();
        final PlayerAction action = state.getAction(new LeftControllerAction());
        final PlayerAction expected = new EmptyPlayerAction();
        assertEquals(expected, action);
    }

}