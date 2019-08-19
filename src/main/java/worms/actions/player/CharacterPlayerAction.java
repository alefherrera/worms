package worms.actions.player;

import worms.Player;
import worms.actions.character.CharacterAction;

import java.util.Objects;

public class CharacterPlayerAction implements PlayerAction {

    private final CharacterAction characterAction;

    public CharacterPlayerAction(final CharacterAction characterAction) {
        this.characterAction = characterAction;
    }

    @Override
    public void execute(final Player player) {
        player.execute(characterAction);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CharacterPlayerAction)) {
            return false;
        }
        final CharacterPlayerAction that = (CharacterPlayerAction) o;
        return Objects.equals(characterAction, that.characterAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterAction);
    }

    @Override
    public String toString() {
        return "CharacterPlayerAction{" +
                "characterAction=" + characterAction +
                '}';
    }
}
