package worms.render;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import worms.engine.Character;
import worms.engine.Position;
import worms.engine.Size;

import javax.inject.Inject;

public class DefaultCharacter implements Character {

    private final Pane pane;
    private final Rectangle aim;

    @Inject
    public DefaultCharacter(final Group group, final String name, final Position position, final Size size) {
        final Rectangle rectangle = new Rectangle(position.getX(), position.getY(), size.getWidth().doubleValue(), size.getHeight().doubleValue());
        rectangle.setFill(Color.RED);
        aim = new Rectangle(position.getX(), position.getY(), 50D, 5D);
        final Text text = new Text(0,20, name);
        final TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(1);
        this.pane = tilePane;
        Pane stack = new StackPane();
        this.pane.setLayoutX(position.getX());
        this.pane.setLayoutY(position.getY());
        stack.getChildren().addAll(rectangle, aim);
        this.pane.getChildren().addAll(text, stack);
        group.getChildren().add(this.pane);
    }

    @Override
    public void moveRight() {
        pane.setTranslateX(pane.getTranslateX() + 5);
    }

    @Override
    public void moveLeft() {
        pane.setTranslateX(pane.getTranslateX() - 5);
    }

    @Override
    public void increaseAngle() {
        aim.setRotate(aim.getRotate() + 5);
    }

    @Override
    public void decreaseAngle() {
        aim.setRotate(aim.getRotate() - 5);
    }
}
