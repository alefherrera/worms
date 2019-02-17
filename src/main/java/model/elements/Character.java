package model.elements;

import model.Player;
import model.Position;
import model.Size;

public class Character extends Element {

    private transient final Player player;

    public Character(Position position, Player player) {
        super(new Size(20D, 20D));
        this.player = player;
        this.position = position;
    }

}
