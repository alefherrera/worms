package worms;

import worms.actions.controller.GameAction;

public class Player {

    private final String name;
    private final Character character;

    public Player(final String name, final Character character) {
        this.name = name;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void execute(final GameAction gameAction) {
        character.execute(gameAction);
    }

}
