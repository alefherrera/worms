package worms.engine.actions.states;

import org.junit.Test;
import worms.engine.actions.movement.MoveLeftAction;
import worms.engine.actions.movement.MoveRightAction;
import worms.engine.actions.ActivateAction;
import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.player.CharacterPlayerAction;
import worms.engine.actions.player.EmptyPlayerAction;
import worms.engine.actions.player.PlayerAction;

import static org.junit.Assert.assertEquals;

public class MovingStateTest {

    @Test
    public void whenActivateActionThenEmpty() {
        final PlayerState state = new MovingState();
        final PlayerAction action = state.getAction(new ActivateAction());
        final PlayerAction expected = new EmptyPlayerAction();
        assertEquals(expected, action);
    }

    @Test
    public void whenExecuteActionThenChangeToAimingState() {
        final PlayerState state = new MovingState();
        final PlayerAction action = state.getAction(new ExecuteAction());
        final PlayerAction expected = new ChangeStateAction(new AimingState());
        assertEquals(expected, action);
    }

    @Test
    public void whenCancelActionThenEmpty() {
        final PlayerState state = new MovingState();
        final PlayerAction action = state.getAction(new CancelAction());
        final PlayerAction expected = new EmptyPlayerAction();
        assertEquals(expected, action);
    }

    @Test
    public void whenRightControllerActionThenMoveRight() {
        final PlayerState state = new MovingState();
        final PlayerAction action = state.getAction(new RightControllerAction());
        final PlayerAction expected = new CharacterPlayerAction(new MoveRightAction());
        assertEquals(expected, action);
    }

    @Test
    public void whenLeftControllerActionThenMoveLeft() {
        final PlayerState state = new MovingState();
        final PlayerAction action = state.getAction(new LeftControllerAction());
        final PlayerAction expected = new CharacterPlayerAction(new MoveLeftAction());
        assertEquals(expected, action);
    }
}