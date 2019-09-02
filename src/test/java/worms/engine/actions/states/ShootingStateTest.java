package worms.engine.actions.states;

import org.junit.Test;
import worms.engine.actions.ActivateAction;
import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.player.CharacterPlayerAction;
import worms.engine.actions.player.EmptyPlayerAction;
import worms.engine.actions.player.PlayerAction;
import worms.engine.actions.power.DecreasePowerAction;
import worms.engine.actions.power.IncreasePowerAction;
import worms.engine.actions.shot.ShotAction;

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
    public void whenExecuteActionThenShot() {
        final PlayerState state = new ShootingState();
        final PlayerAction action = state.getAction(new ExecuteAction());
        final PlayerAction expected = new CharacterPlayerAction(new ShotAction());
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
        final PlayerAction expected = new CharacterPlayerAction(new IncreasePowerAction());
        assertEquals(expected, action);
    }

    @Test
    public void whenLeftControllerActionThenLeftPower() {
        final PlayerState state = new ShootingState();
        final PlayerAction action = state.getAction(new LeftControllerAction());
        final PlayerAction expected = new CharacterPlayerAction(new DecreasePowerAction());
        assertEquals(expected, action);
    }

}