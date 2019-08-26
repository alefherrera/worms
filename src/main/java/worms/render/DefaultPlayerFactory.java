package worms.render;

import javafx.scene.Group;
import worms.engine.CharacterFactory;
import worms.engine.Player;
import worms.engine.PlayerFactory;
import worms.engine.Position;
import worms.engine.Size;
import worms.engine.actions.states.WaitingState;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DefaultPlayerFactory implements PlayerFactory {

    private final CharacterFactory characterFactory;
    private final Group group;
    private final Size defaultSize;

    @Inject
    public DefaultPlayerFactory(final CharacterFactory characterFactory, final Group group) {
        this.characterFactory = characterFactory;
        this.group = group;
        defaultSize = new Size(32, 32);
    }

    @Override
    public Player create(final String name, final Position position) {
        return new Player(name, characterFactory.create(name, position, defaultSize), new WaitingState());
    }
}
