package worms.injector;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GameInjector {

    public static Injector get() {
        return Guice.createInjector(new DefaultModule());
    }

}
