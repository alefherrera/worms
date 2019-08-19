package worms;

import org.junit.Test;
import worms.actions.player.ChangeStateAction;
import worms.actions.controller.ActivateAction;
import worms.actions.controller.ControllerAction;
import worms.actions.controller.GameAction;
import worms.actions.controller.LeftControllerAction;
import worms.actions.controller.RightControllerAction;
import worms.actions.states.MovingState;
import worms.actions.states.WaitingState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    public static final String PLAYER_NAME = "player 1";

    @Test
    public void createPlayer() {
        final Player player = new Player(PLAYER_NAME, null, new MovingState());
        final String playerName = player.getName();
        assertEquals(PLAYER_NAME, playerName);
    }

    @Test
    public void controllerRightAction() {
        final ControllerAction controllerAction = new RightControllerAction();
        final Character character = new Character(new Position(0, 0));
        final Position oldPosition = character.getPosition();
        final Player player = new Player(PLAYER_NAME, character, new MovingState());
        player.execute(controllerAction);
        final Position newPosition = character.getPosition();
        int i = newPosition.getX().compareTo(oldPosition.getX());
        assertTrue("New position isnt grater than the old", i > 0);
    }

    @Test
    public void controllerLeftAction() {
        final ControllerAction controllerAction = new LeftControllerAction();
        final Character character = new Character(new Position(0, 0));
        final Position oldPosition = character.getPosition();
        final Player player = new Player(PLAYER_NAME, character, new MovingState());
        player.execute(controllerAction);
        final Position newPosition = character.getPosition();
        int i = newPosition.getX().compareTo(oldPosition.getX());
        assertTrue("New position is grater than the old", i < 0);
    }

    @Test
    public void activateAction() {
        final GameAction controllerAction = new ActivateAction();
        final Character character = mock(Character.class);
        final Player player = new Player(PLAYER_NAME, character, new WaitingState());
        final ActionExecutionResult executionResult = player.execute(controllerAction);
        assertEquals(new ChangeStateAction(new MovingState()), executionResult.getPlayerAction());
    }

}