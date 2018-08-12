package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {

    private Collection<ActivePlayer> players;
    private Double movingSpeed;
    private Double aimingSpeed;
    private Double powerSpeed;

    public Game() {
        this.players = new HashSet<>();
    }

    public Double getMovingSpeed() {
        return movingSpeed;
    }

    public void setMovingSpeed(Double movingSpeed) {
        this.movingSpeed = movingSpeed;
    }

    public Double getAimingSpeed() {
        return aimingSpeed;
    }

    public void setAimingSpeed(Double aimingSpeed) {
        this.aimingSpeed = aimingSpeed;
    }

    public Double getPowerSpeed() {
        return powerSpeed;
    }

    public void setPowerSpeed(Double powerSpeed) {
        this.powerSpeed = powerSpeed;
    }

    public void addPlayer(Player player) {
        //players.add(new ActivePlayer(player, n));
    }

    public void removePlayer(Player player) {
        List<ActivePlayer> playerList = players.stream().filter(x -> x.getPlayer().equals(player)).collect(Collectors.toList());
        if (playerList.isEmpty()) {
            players.remove(playerList.get(0));
        }
    }
}
