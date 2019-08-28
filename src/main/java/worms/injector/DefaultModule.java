package worms.injector;

import com.google.inject.AbstractModule;
import javafx.scene.Group;
import worms.engine.PlayerFactory;
import worms.render.DefaultPlayerFactory;

public class DefaultModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PlayerFactory.class).to(DefaultPlayerFactory.class);
        bind(Group.class).toInstance(new Group());
    }

}
