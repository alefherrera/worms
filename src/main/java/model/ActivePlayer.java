package model;

public class ActivePlayer {

    private Player player;
    private Stance stance;

    public ActivePlayer(Player player, Stance stance) {
        this.player = player;
        this.stance = stance;
    }

    public Player getPlayer() {
        return player;
    }

    public Stance getStance() {
        return stance;
    }
}
