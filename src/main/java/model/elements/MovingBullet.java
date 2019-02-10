package model.elements;

import model.Position;
import model.Size;

import java.time.LocalTime;
import java.util.function.Function;

public class MovingBullet extends Element {

    private final Function<LocalTime, Position> function;

    public MovingBullet(Size size, Function<LocalTime, Position> function) {
        super(size);
        this.function = function;
    }

    @Override
    public Position getPosition(LocalTime time) {
        return function.apply(time);
    }
}
