package worms.render;

import javafx.scene.Group;
import worms.engine.Character;
import worms.engine.CharacterFactory;
import worms.engine.Position;
import worms.engine.Size;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DefaultCharacterFactory implements CharacterFactory {

    private final Group group;

    @Inject
    public DefaultCharacterFactory(final Group group) {
        this.group = group;
    }

    @Override
    public Character create(final String name, final Position position, final Size size) {
        return new DefaultCharacter(group, name, position, size);
    }
}
