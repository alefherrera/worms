package worms;

import com.google.inject.Injector;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import worms.engine.Game;
import worms.engine.Match;
import worms.engine.MatchConfiguration;
import worms.model.Player;
import worms.engine.PlayerFactory;
import worms.engine.Position;
import worms.engine.actions.controller.ActivateAction;
import worms.engine.actions.controller.CancelAction;
import worms.engine.actions.controller.ControllerAction;
import worms.engine.actions.controller.ExecuteAction;
import worms.engine.actions.controller.LeftControllerAction;
import worms.engine.actions.controller.RightControllerAction;
import worms.injector.GameInjector;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static Map<KeyCode, ControllerAction> getController1() {
        final HashMap<KeyCode, ControllerAction> map = new HashMap<>();
        map.put(KeyCode.D, new RightControllerAction());
        map.put(KeyCode.A, new LeftControllerAction());
        map.put(KeyCode.SPACE, new ExecuteAction());
        map.put(KeyCode.ESCAPE, new CancelAction());
        return map;
    }

    private static Map<KeyCode, ControllerAction> getController2() {
        final HashMap<KeyCode, ControllerAction> map = new HashMap<>();
        map.put(KeyCode.RIGHT, new RightControllerAction());
        map.put(KeyCode.LEFT, new LeftControllerAction());
        map.put(KeyCode.ENTER, new ExecuteAction());
        map.put(KeyCode.BACK_SPACE, new CancelAction());
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
        player2.execute(new ActivateAction());
        primaryStage.setTitle("Game");
        final Group root = injector.getInstance(Group.class);
        final Scene scene = new Scene(root, 800, 600);
        final Map<KeyCode, ControllerAction> controller1 = getController1();
        final Map<KeyCode, ControllerAction> controller2 = getController2();
        scene.setOnKeyPressed(event -> {
            if (controller1.containsKey(event.getCode())) {
                player.execute(controller1.get(event.getCode()));
            }
            if (controller2.containsKey(event.getCode())) {
                player2.execute(controller2.get(event.getCode()));
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
