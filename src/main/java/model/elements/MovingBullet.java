package model.elements;

import model.BattleGround;
import model.Position;
import model.equipment.Bullet;

import java.time.LocalTime;
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
    public void refresh(LocalTime time, BattleGround battleGround) {
        Position newPosition = function.apply(time);
        if (!newPosition.equals(position)) {
            setPosition(newPosition);
            battleGround.update(this);
        }
    }

    @Override
    public void onCollision(Element element) {
        super.onCollision(element);
    }
}
