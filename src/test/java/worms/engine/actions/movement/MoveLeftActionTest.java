package worms.engine.actions.movement;

import org.junit.Test;
import worms.model.behaviors.Movable;
import worms.model.units.Position;

import static org.junit.Assert.*;

public class MoveLeftActionTest {

    @Test
    public void test() {
        final MoveLeftAction action = new MoveLeftAction();
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
        assertEquals(new Position(-5, 0), result.getPosition());
    }

}