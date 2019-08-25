package worms.engine.actions.states;

import org.junit.Test;
import worms.engine.actions.controller.ActivateAction;
import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.player.EmptyPlayerAction;
import worms.engine.actions.player.PlayerAction;

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