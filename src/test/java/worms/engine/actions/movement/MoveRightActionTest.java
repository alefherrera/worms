package worms.engine.actions.movement;

import org.junit.Test;
import worms.model.behaviors.Movable;
import worms.model.units.Position;

import static org.junit.Assert.assertEquals;

public class MoveRightActionTest {

    @Test
    public void test() {
        final MoveRightAction action = new MoveRightAction();
        final Movable target = new Movable() {

            private Position position = new Position(0, 0);

            @Override
            public Position getPosition() {
                return position;
            }

            @Override
            public void setPosition(final Position position) {
                this.position = position;
            }
        };
        final Movable result = action.execute(target);
        assertEquals(result.getPosition(), new Position(5, 0));
    }

}