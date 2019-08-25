package worms.injector;

import com.google.inject.AbstractModule;
import javafx.scene.Group;
import worms.engine.CharacterFactory;
import worms.engine.PlayerFactory;
import worms.render.DefaultCharacterFactory;
import worms.render.DefaultPlayerFactory;

public class DefaultModule extends AbstractModule {

    /**
     * Configures a {@link Binder} via the exposed methods.
     */
    @Override
    protected void configure() {
        bind(PlayerFactory.class).to(DefaultPlayerFactory.class);
        bind(CharacterFactory.class).to(DefaultCharacterFactory.class);
        bind(Group.class).toInstance(new Group());
    }

}
