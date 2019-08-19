package worms.actions.player;

import worms.Player;
import worms.actions.character.CharacterAction;

public class CharacterPlayerAction implements PlayerAction {

    private final CharacterAction characterAction;

    public CharacterPlayerAction(CharacterAction characterAction) {
        this.characterAction = characterAction;
    }

    @Override
    public void execute(final Player player) {
        player.execute(characterAction);
    }
}
