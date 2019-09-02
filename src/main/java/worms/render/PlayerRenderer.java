package worms.render;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import worms.engine.actions.states.PlayerState;
import worms.model.CharacterObserver;
import worms.model.Player;
import worms.model.Character;
import worms.model.units.Aim;
import worms.model.units.Position;
import worms.model.units.Power;
import worms.model.units.Size;
import worms.model.PlayerObserver;

import javax.inject.Inject;

public class PlayerRenderer implements PlayerObserver, CharacterObserver {

    private final Pane pane;
    private final Rectangle aim;
    private final Text state;
    private final Character character;

    @Inject
    public PlayerRenderer(final Group group, final Player player) {
        character = player.getCharacter();
        final Position position = character.getPosition();
        final Size size = character.getSize();
        final Rectangle rectangle = new Rectangle(position.getX(), position.getY(), size.getWidth().doubleValue(), size.getHeight().doubleValue());
        rectangle.setFill(Color.RED);
        aim = new Rectangle(position.getX(), position.getY(), 50D, 5D);
        final Text text = new Text(0,20, player.getName());
        state = new Text(0,20, getPlayerState(player.getPlayerState()));
        final TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(1);
        this.pane = tilePane;
        Pane stack = new StackPane();
        this.pane.setLayoutX(position.getX());
        this.pane.setLayoutY(position.getY());
        stack.getChildren().addAll(rectangle, aim);
        this.pane.getChildren().addAll(text, stack, state);
        group.getChildren().add(this.pane);
    }

    @Override
    public void update() {
        pane.setTranslateX(character.getPosition().getX());
        aim.setRotate(character.getAim().getValue());
    }

    @Override
    public void update(final PlayerState playerState) {
        state.setText(getPlayerState(playerState));
    }

    private String getPlayerState(final PlayerState playerState) {
        return playerState.getClass().getSimpleName();
    }
}
