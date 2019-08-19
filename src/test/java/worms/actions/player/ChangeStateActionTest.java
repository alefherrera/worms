package worms.actions.player;

import org.junit.Test;
import worms.Player;
import worms.actions.controller.GameAction;
import worms.actions.states.AimingState;
import worms.actions.states.MovingState;
import worms.actions.states.PlayerState;
import worms.actions.states.ShootingState;
import worms.actions.states.WaitingState;

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