package worms.actions.states;

import org.junit.Test;
import worms.actions.character.MoveLeftAction;
import worms.actions.character.MoveRightAction;
import worms.actions.controller.ActivateAction;
import worms.actions.controller.CancelAction;
import worms.actions.controller.ExecuteAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;
import worms.actions.player.ChangeStateAction;
import worms.actions.player.CharacterPlayerAction;
import worms.actions.player.EmptyPlayerAction;
import worms.actions.player.PlayerAction;

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