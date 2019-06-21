package worms;

import worms.actions.controller.ActivateAction;
import worms.actions.controller.GameAction;
import worms.actions.states.CharacterState;
import worms.actions.states.WaitingState;

public class Player {

    private final String name;
    private final Character character;
    private CharacterState characterState;

    public Player(final String name, final Character character) {
        this.name = name;
        this.character = character;
        characterState = new WaitingState();
    }

    public String getName() {
        return name;
    }

    public void execute(final GameAction gameAction) {
        characterState = characterState.onAction(gameAction, character);
    }

    public void execute(final ActivateAction gameAction) {
        characterState = characterState.onAction(gameAction, character);
    }
}
