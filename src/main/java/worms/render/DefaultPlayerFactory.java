package worms.render;

import javafx.scene.Group;
import worms.model.Player;
import worms.model.PlayerFactory;
import worms.model.units.Position;
import worms.model.units.Size;
import worms.engine.actions.states.IdleState;
import worms.model.Character;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DefaultPlayerFactory implements PlayerFactory {

    private final Group group;
    private final Size defaultSize;

    @Inject
    public DefaultPlayerFactory(final Group group) {
        this.group = group;
        defaultSize = new Size(32, 32);
    }

    @Override
    public Player create(final String name, final Position position) {
        final Character character = new Character(defaultSize, position);
        final Player player = new Player(name, character, new IdleState());
        final PlayerRenderer playerRenderer = new PlayerRenderer(group, player);
        player.add(playerRenderer);
        character.add(playerRenderer);
        return player;
    }
}
