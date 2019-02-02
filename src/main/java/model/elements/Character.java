package model.elements;

import model.Position;
import model.Size;

public class Character extends Element {

    public Character(Position position) {
        super(new Size(20D, 20D), position);
    }
}
