package model.elements;

import model.Looper;
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
    public void refresh(LocalTime time, Looper looper) {
        Position newPosition = function.apply(time);
        if (!newPosition.equals(position) && newPosition.getY() > 0) {
            setPosition(newPosition);
            looper.needToRefresh();
        }
    }

}
