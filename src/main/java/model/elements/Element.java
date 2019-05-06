package model.elements;

import model.BattleGround;
import model.units.Position;
import model.units.Size;

import java.time.LocalTime;

public abstract class Element {

    private final Size size;

    private final String type;

    protected Position position;

    public Element(Size size) {
        this.size = size;
        type = this.getClass().getSimpleName();
        position = new Position(0D, 0D);
    }

    public Position getPosition() {
        return position;
    }

    public void refresh(LocalTime time, BattleGround battleGround) {

    }

    public void onCollision(Element element) {

    }

    public Size getSize() {
        return size;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
