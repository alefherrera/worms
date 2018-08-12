package model;

public class ActivePlayer {

    private Stance stance;
    private Player player;

    public ActivePlayer(Stance stance, Player player) {
        this.stance = stance;
        this.player = player;
    }

    public Stance getStance() {
        return stance;
    }

    public Player getPlayer() {
        return player;
    }
}
