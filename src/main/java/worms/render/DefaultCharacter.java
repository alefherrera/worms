package worms.render;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import worms.engine.Character;
import worms.engine.Position;
import worms.engine.Size;

import javax.inject.Inject;

public class DefaultCharacter extends Character {

    private final StackPane stackPane;

    @Inject
    public DefaultCharacter(final Group group, final String name, final Position position, final Size size) {
        super(position, size);
        final Rectangle rectangle = new Rectangle(position.getX(), position.getY(), size.getWidth().doubleValue(), size.getHeight().doubleValue());
        rectangle.setFill(Color.RED);
        final Text text = new Text(name);
        stackPane = new StackPane();
        stackPane.setLayoutX(position.getX());
        stackPane.setLayoutY(position.getY());
        stackPane.getChildren().addAll(rectangle, text);
        group.getChildren().add(stackPane);
    }

    @Override
    public void moveRight() {
        stackPane.setTranslateX(stackPane.getTranslateX() + 5);
    }

    @Override
    public void moveLeft() {
        stackPane.setTranslateX(stackPane.getTranslateX() - 5);
    }
}
