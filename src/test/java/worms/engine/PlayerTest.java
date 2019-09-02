package worms.engine;

import org.junit.Test;
import worms.engine.actions.ActivateAction;
import worms.engine.actions.controller.ControllerAction;
import worms.engine.actions.controller.GameAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.engine.actions.player.ChangeStateAction;
import worms.engine.actions.states.MovingState;
import worms.engine.actions.states.IdleState;
import worms.model.ActionExecutionResult;
import worms.model.Character;
import worms.model.Player;
import worms.model.units.Position;
import worms.model.units.Size;

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
        final Character character = new Character(new Size(0,0), new Position(0, 0));
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
        final Character character = new Character(new Size(0,0), new Position(0, 0));
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
        final Player player = new Player(PLAYER_NAME, character, new IdleState());
        final ActionExecutionResult executionResult = player.execute(controllerAction);
        assertEquals(new ChangeStateAction(new MovingState()), executionResult.getPlayerAction());
    }

}