package model;

public class ActivePlayer {

    private Player player;
    private PlayerState stance;

    public ActivePlayer(Player player, PlayerState stance) {
        this.player = player;
        this.stance = stance;
    }

    public Player getPlayer() {
        return player;
    }

    public PlayerState getStance() {
        return stance;
    }
}
