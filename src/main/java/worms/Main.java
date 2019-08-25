package worms;

import com.google.inject.Injector;
import com.google.inject.Provides;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import worms.engine.Game;
import worms.engine.Match;
import worms.engine.MatchConfiguration;
import worms.engine.Player;
import worms.engine.PlayerFactory;
import worms.engine.Position;
import worms.engine.actions.controller.ActivateAction;
import worms.engine.actions.controller.ControllerAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.injector.GameInjector;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static Map<KeyCode, ControllerAction> map = getMap();

    private static Map<KeyCode, ControllerAction> getMap() {
        final HashMap<KeyCode, ControllerAction> map = new HashMap<>();
        map.put(KeyCode.RIGHT, new RightControllerAction());
        map.put(KeyCode.LEFT, new LeftControllerAction());
        return map;
    }

    @Override
    public void start(Stage primaryStage) {
        final Injector injector = GameInjector.get();
        final Game game = injector.getInstance(Game.class);
        game.start();
        final Match match = game.createMatch(new MatchConfiguration());
        final PlayerFactory playerFactory = injector.getInstance(PlayerFactory.class);
        final Player player = playerFactory.create("Player 1", new Position(0, 400));
        final Player player2 = playerFactory.create("Player 2", new Position(300, 400));
        match.addPlayer(player);
        match.addPlayer(player2);
        player.execute(new ActivateAction());
        primaryStage.setTitle("Game");
        final Group root = injector.getInstance(Group.class);
        final Scene scene = new Scene(root, 800, 600);
        scene.setOnKeyPressed(event -> {
            if (map.containsKey(event.getCode())) {
                player.execute(map.get(event.getCode()));
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
