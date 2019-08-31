package worms;

import com.google.inject.Injector;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import worms.model.Game;
import worms.model.Match;
import worms.model.MatchConfiguration;
import worms.model.PlayerFactory;
import worms.model.Position;
import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.controller.ControllerAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.injector.GameInjector;
import worms.model.Player;
import worms.render.KeyCodeController;
import worms.render.MatchRenderer;

import java.util.HashMap;

public class Main extends Application {

    private static KeyCodeController getController1() {
        final HashMap<KeyCode, ControllerAction> map = new HashMap<>();
        map.put(KeyCode.D, new RightControllerAction());
        map.put(KeyCode.A, new LeftControllerAction());
        map.put(KeyCode.SPACE, new ExecuteAction());
        map.put(KeyCode.ESCAPE, new CancelAction());
        return new KeyCodeController("controller1", map);
    }

    private static KeyCodeController getController2() {
        final HashMap<KeyCode, ControllerAction> map = new HashMap<>();
        map.put(KeyCode.RIGHT, new RightControllerAction());
        map.put(KeyCode.LEFT, new LeftControllerAction());
        map.put(KeyCode.ENTER, new ExecuteAction());
        map.put(KeyCode.BACK_SPACE, new CancelAction());
        return new KeyCodeController("controller1", map);
    }

    @Override
    public void start(Stage primaryStage) {
        final Injector injector = GameInjector.get();
        final Game game = injector.getInstance(Game.class);
        game.start();
        final Match match = game.createMatch(new MatchConfiguration(2));
        primaryStage.setTitle("Game");
        final Group root = injector.getInstance(Group.class);
        final Scene scene = new Scene(root, 800, 600);
        final MatchRenderer matchRenderer = new MatchRenderer(root, match);
        createPlayers(match, injector.getInstance(PlayerFactory.class), scene);
        primaryStage.setScene(scene);
        primaryStage.show();
        match.start();
    }

    private void createPlayers(final Match match, final PlayerFactory playerFactory, final Scene scene) {
        final Player player = playerFactory.create("Player 1", new Position(0, 400));
        final Player player2 = playerFactory.create("Player 2", new Position(300, 400));
        match.addPlayer(player);
        match.addPlayer(player2);
        final KeyCodeController controller1 = getController1();
        final KeyCodeController controller2 = getController2();
        controller1.addListener(player);
        controller2.addListener(player2);
        scene.setOnKeyPressed(event -> {
            controller1.onKeyCode(event.getCode());
            controller2.onKeyCode(event.getCode());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
