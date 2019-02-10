package model.elements;

import model.Position;
import model.Size;

import java.time.LocalTime;

public class Character extends Element {

    public Character(Position position) {
        super(new Size(20D, 20D));
        this.position = position;
    }

    @Override
    public Position getPosition(LocalTime time) {
        return position;
    }
}
