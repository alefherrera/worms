package worms.engine.actions.player;

import org.junit.Test;
import worms.model.Player;
import worms.engine.actions.controller.GameAction;
import worms.engine.actions.states.AimingState;
import worms.engine.actions.states.MovingState;
import worms.engine.actions.states.PlayerState;
import worms.engine.actions.states.ShootingState;
import worms.engine.actions.states.WaitingState;

import static org.junit.Assert.assertEquals;

public class ChangeStateActionTest {

    @Test
    public void whenChangeToWaitingStateThenPlayerWaitingState() {
        final PlayerState newState = new WaitingState();
        ChangeStateAction changeStateAction = new ChangeStateAction(newState);
        Player player = new Player("", null, null);
        changeStateAction.execute(player);
        assertEquals(newState, player.getPlayerState());
    }

    @Test
    public void whenChangeToMovingStateThenPlayerMovingState() {
        final PlayerState newState = new MovingState();
        ChangeStateAction changeStateAction = new ChangeStateAction(newState);
        Player player = new Player("", null, null);
        changeStateAction.execute(player);
        assertEquals(newState, player.getPlayerState());
    }

    @Test
    public void whenChangeToShootingStateThenPlayerShootingState() {
        final PlayerState newState = new ShootingState();
        ChangeStateAction changeStateAction = new ChangeStateAction(newState);
        Player player = new Player("", null, null);
        changeStateAction.execute(player);
        assertEquals(newState, player.getPlayerState());
    }

    @Test
    public void whenChangeToAimingThenPlayerAimingState() {
        final PlayerState newState = new AimingState();
        ChangeStateAction changeStateAction = new ChangeStateAction(newState);
        Player player = new Player("", null, null);
        changeStateAction.execute(player);
        assertEquals(newState, player.getPlayerState());
    }

    @Test
    public void whenChangeToUnknownThenPlayerUnknownState() {
        final PlayerState newState = new PlayerState() {
            @Override
            public PlayerAction getAction(final GameAction gameAction) {
                return null;
            }
        };
        ChangeStateAction changeStateAction = new ChangeStateAction(newState);
        Player player = new Player("", null, null);
        changeStateAction.execute(player);
        assertEquals(newState, player.getPlayerState());
    }

}