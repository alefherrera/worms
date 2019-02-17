package model.elements;

import model.Looper;
import model.Position;
import model.equipment.Bullet;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Function;

public class MovingBullet extends Element {

    private final Bullet bullet;
    private final Function<LocalTime, Position> function;

    public MovingBullet(Bullet bullet, Function<LocalTime, Position> function) {
        super(bullet.getSize());
        this.bullet = bullet;
        this.function = function;
    }

    @Override
    public void refresh(LocalTime time, Looper looper, List<Element> otherElements) {
        Position newPosition = function.apply(time);
        if (!newPosition.equals(position) && newPosition.getY() > 0) {
            setPosition(newPosition);
            looper.needToRefresh();
        }
    }

}
